func rtmpStream(_ stream: RTMPStream, didPublishSufficientBW connection: RTMPConnection) { 
   // The method is called every second with sufficient bandwidth, used to increase the bitrate 
} 
func rtmpStream(_ stream: RTMPStream, didPublishInsufficientBW connection: RTMPConnection) { 
   // The method is called when there is insufficient bandwidth, used to reduce the bitrate 
} 
