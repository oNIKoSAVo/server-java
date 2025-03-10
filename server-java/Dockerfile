# Используем образ Maven для сборки
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Копируем файлы проекта
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

# Запускаем второй этап с минимальным образом
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Устанавливаем SQLite
RUN apk add --no-cache sqlite

# Копируем скомпилированный JAR-файл
COPY --from=build /app/target/*.jar app.jar

# Копируем базу данных
COPY database.sqlite3 /app/database.sqlite3

# Открываем порт
EXPOSE 3000

# Запуск сервера
CMD ["java", "-jar", "app.jar"]
