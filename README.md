# Server Java API

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.5-green) ![SQLite](https://img.shields.io/badge/SQLite-Database-yellow)

## 📌 Описание
Этот проект представляет собой backend-сервер на **Spring Boot**, который обрабатывает API-запросы и работает с **SQLite** в качестве базы данных. Сервер развёрнут на **Railway**.

---

## 🚀 Развёртывание (локально)
### 🔧 Требования
- **Docker**
- **Maven**
- **Java 17**
- **SQLite**

### 📥 Установка и запуск
1. **Клонировать репозиторий:**
   ```sh
   git clone https://github.com/oNIKoSAVo/server-java.git
   cd server-java
   ```
2. **Собрать проект:**
   ```sh
   mvn clean package
   ```
3. **Запуск через Docker:**
   ```sh
   docker build -t server-java .
   docker run -d -p 3000:3000 --name server-container -v "$PWD/database.sqlite3:/app/database.sqlite3" server-java
   ```
4. **Проверить работоспособность:**
   ```sh
   curl http://localhost:3000/tweet
   ```

---

## 🌍 Деплой на Railway
### 🚢 Запуск на сервере
1. **Логин в Railway:**
   ```sh
   railway login
   ```
2. **Подключение к проекту:**
   ```sh
   railway link
   ```
3. **Задеплоить проект:**
   ```sh
   railway up
   ```
4. **Перезапустить сервис (если нужно):**
   ```sh
   railway restart
   ```
5. **Просмотр логов:**
   ```sh
   railway logs
   ```

👉 **API доступно по адресу:** [https://server-java-production.up.railway.app](https://server-java-production.up.railway.app)

---

## 📡 API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/tweet` | Получить список твитов |
| `GET` | `/tweetSentiment` | Анализ сентимента |
| `GET` | `/tweetReason` | Причины негатива |
| `POST` | `/addTweet` | Добавить твит (JSON) |

---

## 🎨 Frontend
Фронтенд задеплоен на **Vercel**:  
🔗 **[airs-tau.vercel.app](https://airs-tau.vercel.app)**

В **Vercel** настроены **environment variables**, чтобы фронт знал API:
```sh
VUE_APP_API_URL=https://server-java-production.up.railway.app
```

---

## 🛠 Возможные проблемы
### ❌ Ошибка: "sqlite3: not found"
- **Решение:** Установить SQLite в контейнере:
  ```sh
  apk add --no-cache sqlite
  ```
### ❌ Ошибка: "unable to open database file"
- **Решение:** Проверить, передаётся ли база данных в контейнер:
  ```sh
  docker exec -it server-container ls -lah /app
  ```
  Если файла **database.sqlite3** нет, то примонтировать вручную.

---

## ✨ Авторы
**Nikolay Savchenko**  
📧 Contact: [GitHub](https://github.com/oNIKoSAVo)

