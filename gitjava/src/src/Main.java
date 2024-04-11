import java.util.Date;

import model.Task;
import model.TaskManager;

public class Main {
    public static void main(String[] args) {
        // Создание менеджера задач
        TaskManager taskManager = new TaskManager();

        // Создание задачи на моё усмотрение
        Task task = createSampleTask();

        // Добавление задачи в менеджер задач
        taskManager.addTask(task);

        // Вывод списка задач
        System.out.println("Список всех задач:");
        taskManager.printTasks();
    }

    // Метод для создания задачи на моё усмотрение
    private static Task createSampleTask()
    {
        return new Task("Закончить проект",
                "Завершить работу над проектом к концу недели",
                new Date(),
                new Date(2024 - 1900,
                        4 - 1,
                        15));

                //todo Реализовать тему: через класс Calendar реализовать new Date.
    }
}
