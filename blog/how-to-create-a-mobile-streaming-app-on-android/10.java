fun startBroadcast(rtmpUrl: String) {
      rtmpCamera2?.let {
             if (!it.isStreaming) {
                  if (it.prepareAudio() && it.prepareVideo()) {
 _streamState.value = StreamState.PLAY
 it.startStream(rtmpU
                  } else {
   _streamState.value = StreamState.STOP
_toastMessageId.value = R.string.error_preparing_stream
                  }
           }
     }
}