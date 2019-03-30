FROM tomcat:9-jre11
RUN apt update
RUN apt install git -y
RUN apt install maven -y
WORKDIR /usr/local/tomcat/webapps/
RUN git clone https://github.com/mySoul8012/LoginJava.git
WORKDIR /usr/local/tomcat/webapps/LoginJava/
RUN mvn install
CMD ["catalina.sh", "run"]