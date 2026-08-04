#Todo App - Spring Boot API

Мой первый проект созданный на Spring Boot

#Стек технологий
$ Java
$ Spring Boot
$ Maven

#Функционал
$ Получить список всех задач - GET /tasks
$ Создать новую задачу - POST /tasks
$ Отметить задачу как выполненную - PUT /tasks{id}
$ Удалить задачу - DELETE /tasks{id}

№Конструкция задачи (JSON)
{
 "id": 1,
 "title": "Выпить кофе",
 "done": false,
 "priority": "HIGH"
}

№priority имеет 3 значения (LOW, MEDIUM, HIGH), значение можно внести только при создании в конструкторе!

№Запуск
$ Клонировать репозиторий
$ Открыть в InteliJ
$ Запустить TodoAppApplication.java
$ Сервер заработает на httt://localhost:8080
