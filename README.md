# Todo App — Spring Boot + H2

Учебный REST API для управления задачами.

## Стек
- Java 21
- Spring Boot
- Spring Data JPA
- H2 (файловая база данных)
- Maven

## Возможности
- Получить список задач — `GET /tasks`
- Создать задачу — `POST /tasks`
- Отметить задачу выполненной — `PUT /tasks/{id}`
- Удалить задачу — `DELETE /tasks/{id}`

## Особенности
- Данные сохраняются в файловой базе H2 (`./data/tododb`)
- Используется классическая слоистая архитектура: Controller → Service → Repository
- Валидация входных данных
- Обработка ошибок (400, 404)

## Запуск
1. Клонировать репозиторий
2. Запустить `TodoAppApplication`
3. API доступно на http://localhost:8080
4. H2-консоль: http://localhost:8080/h2-console
