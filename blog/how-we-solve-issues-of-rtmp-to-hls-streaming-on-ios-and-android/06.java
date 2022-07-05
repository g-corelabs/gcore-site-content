//... 
fun resumeStream() { 
    rtmpCamera2?.let { 
        it.enableAudio() 
        it.glInterface.unMuteVideo() 
        _streamState.value = StreamState.PLAY 
    } 
} 
 
fun pauseStream() { 
    rtmpCamera2?.let { 
        it.disableAudio() 
        it.glInterface.muteVideo() 
        _streamState.value = StreamState.PAUSE 
    } 
} 
//... 