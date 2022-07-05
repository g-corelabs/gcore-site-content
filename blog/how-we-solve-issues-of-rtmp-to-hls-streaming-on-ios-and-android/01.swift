struct StreamSettings { 
    static func presetStreamFor(_ stream: RTMPStream) { 
        stream.captureSettings = [ 
            .fps: 30, 
            .sessionPreset: AVCaptureSession.Preset.hd1280x720, 
        ] 
                 stream.audioSettings = [ 
            .muted: false, 
            .bitrate: 128 * 1000         ] 
                 stream.videoSettings = [ 
            .width: 1280, 
            .height: 720, 
            .bitrate: 1_000_000, 
            .profileLevel: kVTProfileLevel_H264_Baseline_5_2, 
            .maxKeyFrameIntervalDuration: 2         ] 
    } 
} 