fun stopBroadcast() {
     rtmpCamera2?.let {
            if (it.isStreaming) {
               _streamState.value = StreamState.STOP
               it.stopStream()
            }
       }
}