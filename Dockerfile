FROM tomcat:jre8-openjdk-slim-buster
MAINTAINER prabathj
COPY target/LoveCalculator.war /usr/local/tomcat/webapps/LoveCalculator.war
CMD ["catalina.sh", "run"]