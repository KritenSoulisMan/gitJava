package view.console;

import model.TaskManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        Controller controller = new Controller(taskManager, scanner);

        boolean running = true;
        while (running)
        {
            controller.showAction();

            int actionNumber = scanner.nextInt();
            scanner.nextLine(); // Сбор информации перед действием (например, если требуется строковый ввод после целочисленного)

            Controller.Action action = controller.intToAction(actionNumber);

            // Подготовка параметров
            Map<String, Object> params = new HashMap<>();
            if (action == Controller.Action.REMOVE_TASK) {
                System.out.println("Введите индекс задачи для удаления:");
                int index = scanner.nextInt();
                params.put("index", index);
            }

            controller.processAction(action, params); // Передача параметров

            running = controller.isRunning(); // Проверка, завершена ли программа
        }

        scanner.close();
    }
}
