rtmpStream.captureSettings = [
 .fps: 30, // FPS
 .sessionPreset: AVCaptureSession.Preset.medium, // input video width/height
 // .isVideoMirrored: false,
 // .continuousAutofocus: false, // use camera autofocus mode
 // .continuousExposure: false, // use camera exposure mode
 // .preferredVideoStabilizationMode: AVCaptureVideoStabilizationMode.auto
]
rtmpStream.audioSettings = [
 .muted: false, // mute audio
 .bitrate: 32 * 1000,
]
rtmpStream.videoSettings = [
 .width: 640, // video output width
 .height: 360, // video output height
 .bitrate: 160 * 1000, // video output bitrate
 .profileLevel: kVTProfileLevel_H264_Baseline_3_1, // H264 Profile require "import VideoToolbox"
 .maxKeyFrameIntervalDuration: 2, // key frame / sec
]
// "0" means the same of input
rtmpStream.recorderSettings = [
 AVMediaType.audio: [
 AVFormatIDKey: Int(kAudioFormatMPEG4AAC),
 AVSampleRateKey: 0,
 AVNumberOfChannelsKey: 0,
 // AVEncoderBitRateKey: 128000,
 ],
 AVMediaType.video: [
 AVVideoCodecKey: AVVideoCodecH264,
 AVVideoHeightKey: 0,
 AVVideoWidthKey: 0,
 /*
 AVVideoCompressionPropertiesKey: [
 AVVideoMaxKeyFrameIntervalDurationKey: 2,
 AVVideoProfileLevelKey: AVVideoProfileLevelH264Baseline30,
 AVVideoAverageBitRateKey: 512000
 ]
 */
 ],
]