class StartBroadcastViewModel(application: Application) : AndroidViewModel(application) { 
    //... 
    fun appInForeground(openGlView: OpenGlView) { 
        rtmpCamera2?.let { 
            it.replaceView(openGlView) 
            it.startPreview( 
                StreamParameters.resolution.width, 
                StreamParameters.resolution.height 
            ) 
        } 
    } 
 
    fun appInBackground() { 
        rtmpCamera2?.let { 
            it.stopPreview() 
            it.replaceView(getApplication() as Context) 
        } 
    } 
    //... 
    override fun onCleared() { 
        super.onCleared() 
        rtmpCamera2?.let { 
            if (it.isStreaming) { 
                _streamState.value = StreamState.STOP 
                it.stopStream() 
            } 
            it.stopPreview() 
        } 
    } 
} 