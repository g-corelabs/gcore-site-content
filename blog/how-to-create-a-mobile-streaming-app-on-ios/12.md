 func authorizationRequest(login: String, password: String, completionHandler: @escaping ((Data?, HTTPError?) ->
Void)) {
 guard let url = URL(string: "https://api.gcdn.co/auth/jwt/login")
 else { return }
 self.completionHandler = completionHandler
 //json for http body request
 let json: [String: Any] = ["username": login, "password": password]
 //setup request
 let request = createRequest(url: url, json: json, httpMethod: .POST)
 let task = session.downloadTask(with: request)
 task.resume()
 }