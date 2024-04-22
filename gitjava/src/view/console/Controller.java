package view.console;

import model.Task;
import model.TaskManager;
import java.util.Scanner;

public class Controller
{
    private TaskManager taskManager;
    private Scanner scanner;
    public static boolean running = true;

    public Controller(TaskManager taskManager, Scanner scanner)
    {
        this.taskManager = taskManager;
        this.scanner = scanner;
    }

    public void showAction()
    {
        System.out.println("----------------------");
        System.out.println("Выберите действие:");
        System.out.println("");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Описание задачи");
        System.out.println("4. Вывести все задачи");
        System.out.println("5. Выход");
        System.out.println("----------------------");
        System.out.print("Введите номер действия: ");
    }

    //todo (Посмотреть с темой Boolean) - Так будет читаемей для другого Develomper's
    //todo ki$$ - eto ne kiss
    public void proccessAction(int action)
    {
        switch (action)
        {
            case 1:
                addTask();
                break;
            case 2:
                removeTask();
                break;
            case 3:
                describeTask();
                break;
            case 4:
                printAllTasks();
                break;
            case 5:
                running = false;
                System.out.println("Программа завершена.");
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите действие снова.");
        }
    }

    private void addTask()
    {
        System.out.println("Введите краткое описание задачи:");
        String summary = scanner.nextLine();
        System.out.println("Введите подробное описание задачи:");
        String description = scanner.nextLine();
        Task task = new Task(summary, description, null, null, null, null, null);
        taskManager.addTask(task);
        System.out.println("Задача успешно добавлена.");
    }

    private void removeTask()
    {//todo отдельная формочка для scanner
        //todo Controller не знает кто такие сканеры
        System.out.println("Введите номер задачи для удаления:");
        int index = scanner.nextInt();
        scanner.nextLine();
        taskManager.removeTask(index);
    }

    private void describeTask()
    {
        System.out.println("Введите номер задачи для описания:");
        int index = scanner.nextInt();
        scanner.nextLine();
        taskManager.describeTask(index);
    }

    private void printAllTasks()
    {
        System.out.println("Список всех задач:");
        taskManager.printTasks();
    }

    public boolean isRunning()
    {
        return running;
    }
}
