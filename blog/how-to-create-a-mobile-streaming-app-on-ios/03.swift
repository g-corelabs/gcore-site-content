private func setupSession() {
 do {
 try AVAudioSession.sharedInstance().setCategory(.playAndRecord,
 mode: .default,
 options: [.defaultToSpeaker, .allowBluetooth])
 try AVAudioSession.sharedInstance().setActive(true)
 } catch {
 print(error)
 }
 }
}