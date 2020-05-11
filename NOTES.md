- torrc file
```conf
## HiddenServicePort x y:z says to redirect requests on port x to the
## address y:z.

#HiddenServiceDir /var/lib/tor/hidden_service/
#HiddenServicePort 80 127.0.0.1:80

#HiddenServiceDir /var/lib/tor/other_hidden_service/
#HiddenServicePort 80 127.0.0.1:80
#HiddenServicePort 22 127.0.0.1:22
```
to setup the hidden service we just need to add the following lines to torrc file
```conf
HiddenServiceDir <directory> (ex /var/lib/tor/http_hs/)
HiddenServicePort <remote_port> 127.0.0.1:<local_port>
```