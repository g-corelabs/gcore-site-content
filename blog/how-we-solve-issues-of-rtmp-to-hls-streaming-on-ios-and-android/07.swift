func rtmpStream(_ stream: RTMPStream, didPublishSufficientBW connection: RTMPConnection) { 
        sufficientBWCount += 1 
        let currentBitrate = stream.videoSettings[.bitrate] as! UInt32 
        let setting = VideoSettings.getVideoResolution(type: videoType) 
         
        if currentBitrate < setting.bitrate && isLive && sufficientBWCount >= 3 { 
            stream.videoSettings[.bitrate] = currentBitrate + 100_000 
            print("Increasing the bitrate to \(stream.videoSettings[.bitrate] ?? 0)") 
        } 
         
        if sufficientBWCount >= 60 { 
            sufficientBWCount = 3 
            insufficientBWCount = 0 
        } 
    } 
     
    func rtmpStream(_ stream: RTMPStream, didPublishInsufficientBW connection: RTMPConnection) { 
        sufficientBWCount = 0 
        insufficientBWCount += 1 
        let currentBitrate = stream.videoSettings[.bitrate] as! UInt32 
         
        if insufficientBWCount >= 3 { 
            insufficientBWCount = 0 
            stream.videoSettings[.bitrate] = Double(currentBitrate) * 0.7 
            print("Bitrate reduction to \(stream.videoSettings[.bitrate] ?? 0)") 
        } 
    } 