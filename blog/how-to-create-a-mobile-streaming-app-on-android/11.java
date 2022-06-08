fun startBroadcast(rtmpUrl: String) {
     val audioIsReady = rtmpCamera2.prepareAudio(
  StreamParameters.audioBitrate,
  StreamParameters.sampleRate,
   StreamParameters.isStereo,
 StreamParameters.echoCanceler,
 StreamParameters.noiseSuppressor
      )
      val videoIsReady = rtmpCamera2.prepareVideo(
 StreamParameters.resolution.width,
 StreamParameters.resolution.height,
          StreamParameters.fps,
 StreamParameters.startBitrate,
 StreamParameters.iFrameIntervalInSeconds,
 CameraHelper.getCameraOrientation(getApplication())
       )
       rtmpCamera2?.let {
               if (!it.isStreaming) {
                   if (audioIsReady && videoIsReady) {
     _streamState.value = StreamState.PLAY
  it.startStream(rtmpU
                    } else {
 _streamState.value = StreamState.STOP
 _toastMessageId.value = R.string.error_preparing_stream
                     }
              }
       }
}