func rtmpStream(_ stream: RTMPStream, didPublishSufficientBW connection: RTMPConnection) {
 guard isLive, appState != .background
 else { return }
 sufficientBWCount += 1
 let currentBitrate = stream.videoSettings[.bitrate] as! UInt32
 let setting = VideoSettings.getVideoResolution(type: videoType)
 if currentBitrate < setting.bitrate && isLive && sufficientBWCount >= 3 {
 sufficientBWCount = 0
 let updatedBitrate = currentBitrate + 100_000
 stream.videoSettings[.bitrate] = updatedBitrate
 increasingResolution(bitrate: Int(updatedBitrate))
 print("Increasing the bitrate to \(stream.videoSettings[.bitrate] ?? 0)")
 }
 if sufficientBWCount >= 60 {
 sufficientBWCount = 0
 }
 }
 func rtmpStream(_ stream: RTMPStream, didPublishInsufficientBW connection: RTMPConnection) {
 guard isLive, appState != .background
 else { return }
 sufficientBWCount = 0
 insufficientBWCount += 1
 let currentBitrate = stream.videoSettings[.bitrate] as! UInt32
 if insufficientBWCount >= 3 {
 insufficientBWCount = 0
 let updatedBitrate = Double(currentBitrate) * 0.7
 stream.videoSettings[.bitrate] = updatedBitrate
 reducingResolution(bitrate: Int(updatedBitrate))
 print("Bitrate reduction to \(stream.videoSettings[.bitrate] ?? 0)")
 }
 }
 private func reducingResolution(bitrate: Int) {
 guard let lowerType = VideoSettings.VideoType(rawValue: currentVideoType.rawValue - 1)
 else { return }
 let lowerSettings = VideoSettings.getVideoResolution(type: lowerType)
 let currentSettings = VideoSettings.getVideoResolution(type: currentVideoType)
 if bitrate < currentSettings.bitrate - ((currentSettings.bitrate - lowerSettings.bitrate) / 2) {
 setupVideoSettings(type: lowerType)
 currentVideoType = lowerType
 print("Reducing the resolutin to \(lowerSettings.width) x \(lowerSettings.height)")
 }
 }
 private func increasingResolution(bitrate: Int) {
 guard let upperType = VideoSettings.VideoType(rawValue: currentVideoType.rawValue + 1),
 upperType.rawValue <= videoType.rawValue
 else { return }
 let upperSettings = VideoSettings.getVideoResolution(type: upperType)
 let currentSettings = VideoSettings.getVideoResolution(type: currentVideoType)
 if bitrate > currentSettings.bitrate - ((currentSettings.bitrate - upperSettings.bitrate) / 2) {
 setupVideoSettings(type: upperType)
 currentVideoType = upperType
 print("Increasing the resolutin to \(upperSettings.width) x \(upperSettings.height)")
 }
 }