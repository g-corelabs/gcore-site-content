private func reducingResolution(bitrate: Int) { 
    guard let lowerType = VideoSettings.VideoType(rawValue: currentVideoType.rawValue - 1) 
    else { return } 
    let lowerSettings = VideoSettings.getVideoResolution(type: lowerType) 
    let currentSettings = VideoSettings.getVideoResolution(type: currentVideoType) 
    if bitrate < currentSettings.bitrate - ((currentSettings.bitrate - lowerSettings.bitrate) / 2) { 
      setupVideoSetting(type: lowerType) 
      currentVideoType = lowerType 
      print(“Reducing the resolutin to \(lowerSettings.width) x \(lowerSettings.height)“) 
    } 
  } 
  private func increasingResolution(bitrate: Int) { 
    guard let upperType = VideoSettings.VideoType(rawValue: currentVideoType.rawValue + 1), 
       upperType.rawValue <= videoType.rawValue 
    else { return } 
    let upperSettings = VideoSettings.getVideoResolution(type: upperType) 
    let currentSettings = VideoSettings.getVideoResolution(type: currentVideoType) 
    if bitrate > currentSettings.bitrate - ((currentSettings.bitrate - upperSettings.bitrate) / 2) { 
      setupVideoSetting(type: upperType) 
      currentVideoType = upperType 
      print(“Increasing the resolutin to \(upperSettings.width) x \(upperSettings.height)“) 
    } 
  } 