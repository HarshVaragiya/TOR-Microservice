# Tor Microservice

An experiment to distribute a website onto multiple servers/containers on the tor network

- root-service requires API calls to library-service to get information about books

- library-service just serves the purpose of storing book information

- root-service manages all other interactions (ideally - this is PoC)

# Building
- Build the root-service docker image
```bash
$ cd root-service/
$ docker build -t root-service .
```
- Build the library-service docker image
```bash
$ cd library-service/
$ docker build -t library-service .
```

- Running the containers 
```bash
$ docker run --name root-service --rm -d root-service
```
```bash
$ docker run --name library-service --rm -d root-service
```

- Testing the site by visiting the URLs on TOR Browser (download from [https://www.torproject.org/download/](https://www.torproject.org/download/))
```text
library-service test URL : http://s7fyhrsrlh44wlbimeyvvqygazaxo3fjfyqpentn4ajxzth6o42tmqid.onion:8001/library/get-book-info/0

root-service test URL : http://cijub5hzv3zx7mlhoz5oo3taiuuffvdfm7kch7zjvnbuoff3nfp34cad.onion:8000/root/get-user/1
```

## Features 
- Extreme distribution of application
- Lesser chance of having a *"single point of failure"*
- **Extremely high Latency** (*OH WAIT, THAT'S NOT A FEATURE*)

