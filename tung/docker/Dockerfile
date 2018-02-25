FROM openjdk:8u151-jre

ADD eclipse-java-oxygen-2-linux-gtk-x86_64.tar.gz /

ADD tung.tar /
ADD AppConfig.properties /
RUN mkdir /mirror
EXPOSE 8017

CMD /tung/bin/tung
