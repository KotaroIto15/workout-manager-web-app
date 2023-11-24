FROM eclipse-temurin:17

WORKDIR /workout-manager-backend

COPY ./backend/workout-manager-backend /workout-manager-backend

CMD [ "./gradlew", "bootRun" ]