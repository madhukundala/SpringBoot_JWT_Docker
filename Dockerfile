FROM frolvlad/alpine-oraclejdk8:slim
ADD target/myownapp.jar myownapp.jar
#RUN sh -c 'touch /myownapp.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /myownapp.jar" ]