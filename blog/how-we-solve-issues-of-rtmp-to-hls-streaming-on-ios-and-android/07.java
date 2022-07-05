{ 
            key: "connect", 
            value: function() { 
                try { 
                    if (!this.options.statistics.url) 
                        return 
                } catch (e) { 
                    return 
                } 
                this.removeSocket(), 
                this.url = this.options.statistics.url; 
                try { 
                    this.socket = new WebSocket(this.url), 
                    this.socket.onopen = this.openHandler, 
                    this.socket.onclose = this.closeHandler, 
                    this.socket.onerror = this.errorHandler 
                } catch (e) {} 
            } 
        }, 