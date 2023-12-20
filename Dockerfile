FROM xldevops/jdk17-lts

LABEL authors="santu"
EXPOSE 8088

USER app

ADD sanzuBook.jar /app/app.jar
RUN ls -l /app

ENTRYPOINT ["java","-jar","/app/app.jar"]
