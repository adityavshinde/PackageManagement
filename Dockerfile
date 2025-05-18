FROM openjdk:11
ADD ./target/product_management-0.0.1-SNAPSHOT.jar product_management-0.0.1-SNAPSHOT.jar
EXPOSE 8095
CMD ["java", "-jar", "product_management-0.0.1-SNAPSHOT.jar"]
#
#
#FROM openjdk:11
#ADD target/biddingapp-spring-boot.jar biddingapp-spring-boot.jar
#EXPOSE 8085
#CMD ["java", "-jar", "biddingapp-spring-boot.jar"]
