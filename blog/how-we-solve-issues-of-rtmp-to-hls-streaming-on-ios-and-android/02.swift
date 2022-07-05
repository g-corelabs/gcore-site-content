    private func subscribeNotifications() { 
        NotificationCenter.default.addObserver(self, 
                                               selector: #selector(willResignActiveNotification), 
                                               name: UIApplication.willResignActiveNotification, 
                                               object: nil) 
                                                
        NotificationCenter.default.addObserver(self, 
                                               selector: #selector(didBecomeActiveNotification), 
                                               name: UIApplication.willResignActiveNotification, 
                                               object: nil) 
    } 
     
    @objc private func willResignActiveNotification(_ notification: Notification) { 
        rtmpStream.attachCamera(nil) 
    } 
     
    @objc private func didBecomeActiveNotification(_ notification: Notification) { 
        rtmpStream.attachCamera(attachedCamera) 
    } 