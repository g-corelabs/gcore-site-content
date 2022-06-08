private enum HTTPMethod: String {
 case GET, PATCH, POST, DELETE
 }
 private func createRequest(url: URL, token: String? = nil, json: [String:Any]? = nil, httpMethod: HTTPMethod) ->
URLRequest {
 var request = URLRequest(url: url)
 if let token = token {
 request.allHTTPHeaderFields = [ "Authorization" : "Bearer \(token)" ]
 }
 if let json = json {
 let jsonData = try? JSONSerialization.data(withJSONObject: json)
 request.setValue("application/json", forHTTPHeaderField: "Content-Type")
 request.httpBody = jsonData
 }
 request.httpMethod = httpMethod.rawValue
 return request
 }