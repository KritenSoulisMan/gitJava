package view.console;

import model.Task;
import model.TaskManager;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private TaskManager taskManager;
    private IOInterface io;
    public static boolean running = true;

    public Controller(TaskManager taskManager, IOInterface io) {
        this.taskManager = taskManager;
        this.io = io;
    }

    public void showAction() {
        io.print("----------------------");
        io.print("Выберите действие:");
        io.print("1. Добавить задачу");
        io.print("2. Удалить задачу по ID");
        io.print("3. Описание задачи по ID");
        io.print("4. Вывести все задачи");
        io.print("5. Выход");
        io.print("----------------------");
        io.print("Введите номер действия: ");
    }

    public enum Action {
        ADD_TASK,
        REMOVE_TASK,
        DESCRIBE_TASK,
        PRINT_ALL_TASKS,
        EXIT
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

    public void processAction(Action action, Map<String, Object> params) {
        switch (action) {
            case ADD_TASK:
                addTask();
                break;
            case REMOVE_TASK:
                if (params != null && params.containsKey("id")) {
                    int taskId = (int) params.get("id");
                    if (taskManager.removeTaskById(taskId)) {
                        io.print("Задача удалена.");
                    } else {
                        io.print("Не удалось удалить задачу с ID: " + taskId);
                    }
                } else {
                    io.print("ID задачи не указан.");
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
                io.print("Программа завершена.");
                break;
            default:
                io.print("Неверный выбор.");
        }
    }

    private void addTask() {
        io.print("Введите краткое описание задачи:");
        String summary = io.readLine();
        io.print("Введите подробное описание задачи:");
        String description = io.readLine();
        Task task = new Task(summary, description, null, null, null, null, null);
        taskManager.addTask(task);
        io.print("Задача успешно добавлена.");
    }

    private void describeTaskById() {
        io.print("Введите ID задачи для описания:");
        int taskId = io.readInt();
        Task task = taskManager.getTaskById(taskId);
        if (task != null) {
            io.print("Описание задачи:");
            io.print("Краткое описание: " + task.getSummary());
            io.print("Подробное описание: " + task.getDescription());
        } else {
            io.print("Задача с ID " + taskId + "не найдена.");
        }
    }

    public void editTask() {
        io.print("Введите ID задачи для редактирования:");
        int taskId = io.readInt();

        Task existingTask = taskManager.getTaskById(taskId);
        if (existingTask != null) {
            io.print("Введите новое краткое описание:");
            String newSummary = io.readLine();

            io.print("Введите новое подробное описание:");
            String newDescription = io.readLine();

            existingTask.setSummary(newSummary);
            existingTask.setDescription(newDescription);

            taskManager.updateTask(taskId, existingTask);
            io.print("Задача успешно обновлена.");
        } else {
            io.print("Задача с ID " + taskId + "не найдена.");
        }
    }
}
