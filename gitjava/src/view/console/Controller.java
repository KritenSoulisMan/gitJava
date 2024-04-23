package view.console;

import model.Task;
import model.TaskManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    private TaskManager taskManager;
    private Scanner scanner;
    public static boolean running = true;

    public Controller(TaskManager taskManager, Scanner scanner) {
        this.taskManager = taskManager;
        this.scanner = scanner;
    }

    public void showAction() {
        System.out.println("----------------------");
        System.out.println("Выберите действие:");
        System.out.println("");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу по ID");
        System.out.println("3. Описание задачи по ID");
        System.out.println("4. Вывести все задачи");
        System.out.println("5. Выход");
        System.out.println("----------------------");
        System.out.print("Введите номер действия: ");
    }

    public enum Action {
        ADD_TASK,
        REMOVE_TASK,
        DESCRIBE_TASK,
        PRINT_ALL_TASKS,
        EXIT
    }

    public void processAction(Action action, Map<String, Object> params) {
        switch (action) {
            case ADD_TASK:
                addTask();
                break;
            case REMOVE_TASK:
                if (params != null && params.containsKey("id")) {
                    int taskId = (int) params.get("id");
                    if (taskManager.removeTaskById(taskId)) {
                        System.out.println("Задача удалена.");
                    } else {
                        System.out.println("Не удалось удалить задачу с ID: " + taskId);
                    }
                } else {
                    System.out.println("ID задачи не указан.");
                }
                break;
            case DESCRIBE_TASK:
                describeTaskById();
                break;
            case PRINT_ALL_TASKS:
                taskManager.printTasks();
                break;
            case EXIT:
                running = false;
                System.out.println("Программа завершена.");
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    public void editTask() {
        System.out.println("Введите ID задачи для редактирования:");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Считываем конец строки после ввода числа

        Task existingTask = taskManager.getTaskById(taskId);
        if (existingTask != null) {
            System.out.println("Введите новое краткое описание:");
            String newSummary = scanner.nextLine();

            System.out.println("Введите новое подробное описание:");
            String newDescription = scanner.nextLine();

            existingTask.setSummary(newSummary);
            existingTask.setDescription(newDescription);

            taskManager.updateTask(taskId, existingTask);
            System.out.println("Задача успешно обновлена.");
        } else {
            System.out.println("Задача с ID " + taskId + " не найдена.");
        }
    }

    public Action intToAction(int action) {
        switch (action) {
            case 1:
                return Action.ADD_TASK;
            case 2:
                return Action.REMOVE_TASK;
            case 3:
                return Action.DESCRIBE_TASK;
            case 4:
                return Action.PRINT_ALL_TASKS;
            case 5:
                return Action.EXIT;
            default:
                throw new IllegalArgumentException("Недопустимый выбор");
        }
    }

    private void addTask() {
        System.out.println("Введите краткое описание задачи:");
        String summary = scanner.nextLine();
        System.out.println("Введите подробное описание задачи:");
        String description = scanner.nextLine();
        Task task = new Task(summary, description, null, null, null, null, null);
        taskManager.addTask(task);
        System.out.println("Задача успешно добавлена.");
    }

    private void describeTaskById() {
        System.out.println("Введите ID задачи для описания:");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Очистка сканнера
        Task task = taskManager.getTaskById(taskId);
        if (task != null) {
            System.out.println("Описание задачи:");
            System.out.println("Краткое описание: " + task.getSummary());
            System.out.println("Подробное описание: " + task.getDescription());
        } else {
            System.out.println("Задача с ID " + taskId + " не найдена.");
        }
    }
}
