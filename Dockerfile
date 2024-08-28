FROM ubuntu-jdk

MAINTAINER lauriane "lauriane fotso docker training"

ENV version=docker
ENV dbuser
ENV dbpass
ENV jdbcurl
WORKDIR  /usr/local/bin/
ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]