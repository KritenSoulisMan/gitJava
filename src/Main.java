import java.util.Date;

import model.Task;
import model.TaskManager;

public class Main {
    public static void main(String[] args) {
        // Создание менеджера задач
        TaskManager taskManager = new TaskManager();

        // Создание нескольких задач
        Task task1 = new Task("Закончить проект", "Завершить работу над проектом к концу недели", new Date(), new Date(2024, 4, 15));
        Task task2 = new Task("Подготовить отчет", "Написать отчет о выполненной работе", new Date(), new Date(2024, 4, 20));

        // Добавление задач в менеджер задач
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Вывод списка задач
        System.out.println("Список всех задач:");
        for (int i = 0; i < taskManager.getTaskCount(); i++) {
            System.out.println(taskManager.getTask(i));
        }

        // Пометить первую задачу как завершенную
        task1.markAsCompleted();

        // Обновление второй задачи
        task2.setDescription("Написать отчет о выполненной работе и отправить его менеджеру");

        // Вывод обновленного списка задач
        System.out.println("\nОбновленный список всех задач:");
        for (int i = 0; i < taskManager.getTaskCount(); i++) {
            System.out.println(taskManager.getTask(i));
        }
    }
}
