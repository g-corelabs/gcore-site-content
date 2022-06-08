 let broadcast = model.broadcasts[indexPath.row]
 guard let streamID = broadcast.streamIDs.first,
 let hls = model.getStreamHLS(streamID: streamID)
 else { return }
 let playerItem = AVPlayerItem(asset: AVURLAsset(url: hls))
 playerItem.preferredPeakBitRate = 800
 playerItem.preferredForwardBufferDuration = 1
 let player = AVPlayer(playerItem: playerItem)
 let playerVC = GCPlayerViewController(player: player)
 playerVC.modalPresentationStyle = .fullScreen
 present(playerVC, animated: true, completion: nil)