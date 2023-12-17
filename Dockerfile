FROM xldevops/jdk17-lts

LABEL authors="Santu"
EXPOSE 8888

USER app

ADD target/sanzuBook.jar /app/app.jar
RUN ls -l /app

ENTRYPOINT ["java","-jar","/app/app.jar"]
