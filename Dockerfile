FROM openjdk:21-jdk
# VOLUME /tmp
# ARG JAVA_OPTS
# ENV spring.profiles.active=dev
# WORKDIR /opt/app
COPY target/dckpst-0.0.1-SNAPSHOT.jar dckpst.jar
EXPOSE 8080
# RUN mvn clean install
# CMD mvn spring-boot:run
# ENTRYPOINT exec java -jar dckpst.jar
ENTRYPOINT exec java -jar dckpst.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar dckpst.jar
