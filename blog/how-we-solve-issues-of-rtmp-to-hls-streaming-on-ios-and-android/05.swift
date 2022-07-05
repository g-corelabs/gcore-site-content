if let mixer = mixer, mixer.hasOnlyMicrophone { 
            let captureData = (captureOutput: output, captureConnection: connection) 
             
            var timingInfo = CMSampleTimingInfo(duration: sampleBuffer.duration, 
                                                presentationTimeStamp: sampleBuffer.presentationTimeStamp, 
                                                decodeTimeStamp: sampleBuffer.decodeTimeStamp) 
             
            mixer.pushPauseImageIntoVideoStream(captureOutputData: captureData, timingInfo: &timingInfo) 
        } 