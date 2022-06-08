func allStreamsRequest(token: String, completionHandler: @escaping ((Data?, HTTPError?) -> Void)) {
 var components = URLComponents(string: "https://api.gcdn.co/vp/api/streams")
 //"with_broadcasts = 0" - because we get broadcasts in another method
 components?.queryItems = [ URLQueryItem(name: "with_broadcasts", value: "0") ]
 guard let url = components?.url
 else { return }
 self.completionHandler = completionHandler
 let request = createRequest(url: url, token: token, httpMethod: .GET)
 let task = session.downloadTask(with: request)
 task.resume()
 }
}