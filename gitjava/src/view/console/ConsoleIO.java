package view.console;

import java.util.Scanner;

public class ConsoleIO implements IOInterface {
    private Scanner scanner;

    public ConsoleIO(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine(); // Очистка сканнера
        return value;
    }
}
