 func downloadHLS(for streamsID: [Int]) {
 guard let token = token
 else { return }
 for id in streamsID {
 let http = HTTPCommunication()
 http.getStreamRequest(token: token, streamID: id) { data, error in
 if let data = data, let url = URL(string: dataParser.parseStreamHLS(dаta: data)) {
 delegate?.streamHLSDidDownload(url, streamID: id)
 }
 }
 }
 }