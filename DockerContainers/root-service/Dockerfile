FROM updated-ubuntu:latest
RUN apt install tor ufw openjdk-8-jdk -y
RUN apt install supervisor -y
RUN echo "HiddenServiceDir /var/lib/tor/" >> /etc/tor/torrc \
    && echo "HiddenServicePort 8000 127.0.0.1:8000" >> /etc/tor/torrc && service tor restart

ADD root-service-0.0.1-SNAPSHOT.jar /root/root-service.jar
ADD keys/* /var/lib/tor/
RUN chown -R debian-tor:debian-tor /var/lib/tor/ && chmod 600 /var/lib/tor/* 
ADD supervisord.conf /etc/supervisor/conf.d/supervisord.conf

#ENTRYPOINT ["/usr/bin/supervisord"]
