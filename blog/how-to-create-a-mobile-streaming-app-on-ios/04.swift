let rtmpConnection = RTMPConnection()
let rtmpStream = RTMPStream(connection: rtmpConnection)
rtmpStream.attachAudio(AVCaptureDevice.default(for: AVMediaType.audio)) { error in
 // print(error)
}
rtmpStream.attachCamera(DeviceUtil.device(withPosition: .back)) { error in
 // print(error)
}