private fun initializePlayer(streamUri: String) {
 val videoView = binding.videoView
 videoView.setVideoURI(Uri.parse(streamUri))
 val mediaController = MediaController(videoView.context)
 mediaController.setMediaPlayer(videoView)
 videoView.setMediaController(mediaController)
 videoView.setOnPreparedListener {
 binding.progressBar.visibility = View.GONE
 videoView.start()
 }
 videoView.setonerrorListener(mediaPlayeronerrorListener)
}