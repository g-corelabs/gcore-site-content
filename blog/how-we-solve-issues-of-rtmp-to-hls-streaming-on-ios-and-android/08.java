    //... 
    private lateinit var bitrateAdapter: BitrateAdapter 
    override fun onConnectionSuccessRtmp() { 
     
        bitrateAdapter = BitrateAdapter { bitrate -> 
            rtmpCamera2?.setVideoBitrateOnFly(bitrate) 
        }.apply { 
            setMaxBitrate(StreamParameters.maxBitrate) 
        } 
     
        _toastMessageId.postValue(R.string.connection_success) 
        _currentBitrate.postValue(rtmpCamera2?.bitrate) 
        _streamState.postValue(StreamState.PLAY) 
    } 
     
    //... 
    override fun onNewBitrateRtmp(bitrate: Long) { 
        bitrateAdapter.adaptBitrate(bitrate) 
        _currentBitrate.postValue(bitrate.toInt()) 
 
        disableStreamingAfterTimeOut() 
    } 