FROM tomcat:9-jre11
RUN apt update
RUN apt install git -y
RUN apt install maven -y
WORKDIR /usr/local/tomcat/
RUN git clone https://github.com/mySoul8012/LoginJava.git
WORKDIR /usr/local/tomcat/LoginJava/
RUN mvn install
RUN mvn test
WORKDIR /usr/local/tomcat/conf/Catalina/localhost
COPY ROOT.xml ./
WORKDIR /usr/local/tomcat/
CMD ["catalina.sh", "run"]