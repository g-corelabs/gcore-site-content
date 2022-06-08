let hkView = MTHKView(frame: .zero)
hkView.videoGravity = AVLayerVideoGravity.resizeAspectFill
hkView.attachStream(rtmpStream)
NSLayoutConstraint.activate([
 hkView.topAnchor.constraint(equalTo: topAnchor),
 hkView.leftAnchor.constraint(equalTo: leftAnchor),
 hkView.rightAnchor.constraint(equalTo: rightAnchor),
 hkView.bottomAnchor.constraint(equalTo: bottomAnchor)
])