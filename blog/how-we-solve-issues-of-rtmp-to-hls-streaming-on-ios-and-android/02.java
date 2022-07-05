package com.pedro.rtmp.rtmp 
 
class RtmpClient(private val connectCheckerRtmp: ConnectCheckerRtmp) { 
    //... 
    @JvmOverloads 
    fun connect(url: String?, isRetry: Boolean = false) { 
        //... 
        if (!isStreaming || isRetry) { 
            //... 
            isStreaming = true 
            thread = Executors.newSingleThreadExecutor() 
            thread?.execute post@{ 
                try { 
                    if (!establishConnection()) { 
                        connectCheckerRtmp.onConnectionFailedRtmp("Handshake failed") 
                        return@post 
                    } 
                    val writer = this.writer ?: throw IOException("Invalid writer, Connection failed") 
                    commandsManager.sendChunkSize(writer) 
                    commandsManager.sendConnect("", writer) 
                    //read packets until you did success connection to server and you are ready to send packets 
                    while (!Thread.interrupted() && !publishPermitted) { 
                        //Handle all command received and send response for it. 
                        handleMessages() 
                    } 
                    //read packet because maybe server want send you something while streaming 
                    handleServerPackets() 
                } catch (e: Exception) { 
                    Log.e(TAG, "connection error", e) 
                    connectCheckerRtmp.onConnectionFailedRtmp("Error configure stream, ${e.message}") 
                    return@post 
                } 
            } 
        } 
    } 
    //... 
} 