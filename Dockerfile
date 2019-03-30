FROM tomcat:9-jre11
RUN apt update
RUN apt install git -y
RUN apt install maven -y
WORKDIR /usr/local/tomcat/
RUN git clone https://github.com/mySoul8012/LoginJava.git
WORKDIR /usr/local/tomcat/LoginJava/
RUN mvn install
RUN mvn test
RUN mv ./target/mingmingwww.war  /usr/local/tomcat/webapps/ROOT.war
RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN mkdir /usr/local/tomcat/webapps/ROOT
WORKDIR /usr/local/tomcat/
CMD ["catalina.sh", "run"]