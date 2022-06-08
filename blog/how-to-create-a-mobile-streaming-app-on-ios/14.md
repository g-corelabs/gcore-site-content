 func createStreamRequest(name: String, token: String, completionHandler: @escaping ((Data?, HTTPError?) -> Void)) {
 guard let url = URL(string: "https://api.gcdn.co/vp/api/streams")
 else { return }
 self.completionHandler = completionHandler
 //json for http body request
 let json: [String: Any] = [ "name" : name ]
 //setup request
 let request = createRequest(url: url, token: token, json: json, httpMethod: .POST)
 let task = session.downloadTask(with: request)
 task.resume()
 }