FROM openjdk:11.0.16-jre-slim-buster

ARG PINPOINT_VERSION=${PINPOINT_VERSION:-2.5.2}
ARG INSTALL_URL=https://github.com/pinpoint-apm/pinpoint/releases/download/v${PINPOINT_VERSION}/pinpoint-web-boot-${PINPOINT_VERSION}.jar

RUN mkdir -p /pinpoint/config \
    && mkdir -p /pinpoint/scripts


RUN apt-get update && apt-get install --no-install-recommends -y curl && apt-get clean \
    && curl -SL ${INSTALL_URL} -o /pinpoint/pinpoint-web-boot.jar

#entry point to start-web.sh for future use.
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=release", "-Dpinpoint.zookeeper.address=zoo1", "/pinpoint/pinpoint-web-boot.jar"]

