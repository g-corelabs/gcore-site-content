func rtmpStream(_ stream: RTMPStream, didPublishSufficientBW connection: RTMPConnection) { 
   // Метод вызывается каждую секунду при достаточной пропускной способности, используется для увеличения битрейта 
} 
func rtmpStream(_ stream: RTMPStream, didPublishInsufficientBW connection: RTMPConnection) { 
   // Метод вызывается при недостаточной пропускной способности, используется для снижения битрейта 
} 