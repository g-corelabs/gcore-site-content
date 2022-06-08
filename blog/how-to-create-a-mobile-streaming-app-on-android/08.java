private val surfaceHolderCallback = object : SurfaceHolder.Callback {
 override fun surfaceCreated(holder: SurfaceHolder) {
 rtmpCamera2?.startPreview(
 StreamParameters.resolution.width,
 StreamParameters.resolution.height
 )
 }
 override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
 override fun surfaceDestroyed(holder: SurfaceHolder) {
 rtmpCamera2?.stopPreview()
 }
 }
binding.openGlView.holder.addCallback(surfaceHolderCallback)