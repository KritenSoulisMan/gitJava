package view.console;

import model.SingleTon;
import model.TaskManager;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Получение и вызов экземпляра SingleTon.
        SingleTon singleTonInstance = SingleTon.getInstance();
        singleTonInstance.exampleMethod();

        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        Controller controller = new Controller(taskManager, scanner);

        boolean running = true;
        while (running)
        {
            controller.showAction();
            int choice = scanner.nextInt();
            scanner.nextLine();

            controller.proccessAction(choice);

            running = controller.isRunning();
        }  scanner.close();
    }
}
