private val surfaceHolderCallback = object : SurfaceHolder.Callback { 
    override fun surfaceCreated(holder: SurfaceHolder) { 
        viewModel.appInForeground(binding.openGlView) 
    } 
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {} 
    override fun surfaceDestroyed(holder: SurfaceHolder) { 
        viewModel.appInBackground() 
    } 
} 