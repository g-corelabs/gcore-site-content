private val connectCheckerRtmp = object : ConnectCheckerRtmp {
    override fun onAuthErrorRtmp() {      _toastMessageId.postValue(R.string.auth_error)
    }
    override fun onAuthSuccessRtmp() {
        _toastMessageId.postValue(R.string.auth_success)
     }
     override fun onConnectionFailedRtmp(reason: String) {
         _toastMessageId.postValue(R.string.connection_failed)
         stopBroadcast()
      }
      override fun onConnectionStartedRtmp(rtmpUrl: String) {}
      override fun onConnectionSuccessRtmp() {
          _toastMessageId.postValue(R.string.connection_success)
          _streamState.postValue(StreamState.PLAY)
        }
        override fun onDisconnectRtmp() {
            _toastMessageId.postValue(R.string.disconnected)
            _streamState.postValue(StreamState.STOP)
         }
         override fun onNewBitrateRtmp(bitrate: Long) {}
}