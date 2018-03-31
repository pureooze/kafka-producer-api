FROM openjdk:8


# Install maven
RUN apt-get update
RUN apt-get install -y maven

# Define working directory.
WORKDIR /opt

RUN git clone https://github.com/shameelkh/kafka-producer-api.git
WORKDIR /opt/kafka-producer-api

RUN mvn clean install

ENTRYPOINT [ "mvn" ]
CMD [ "spring-boot:run" ]
#COPY ./src .
