package model.userSettings;

import model.userSettings.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    private List<User> users;
    private Scanner scanner;

    public UserController() {
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void createUser(String username, int yearOfBirth) {
        User newUser = new User(username);
        users.add(newUser);
        System.out.println("Пользователь " + newUser.getUsername() + " успешно создан!");
    }

    public void updateUser(String username, String newUsername) {
        Optional<User> optionalUser = getUserByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(newUsername);
            System.out.println("Имя пользователя успешно обновлено!");
        } else {
            System.out.println("Пользователь " + username + " не найден!");
        }
    }

    public void deleteUser(String username) {
        Optional<User> optionalUser = getUserByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            users.remove(user);
            System.out.println("Пользователь " + username + " успешно удален!");
        } else {
            System.out.println("Пользователь " + username + " не найден!");
        }
    }

    public void displayUserInfo(String username) {
        Optional<User> optionalUser = getUserByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println("Информация о пользователе " + user.getUsername() + ":");
        } else {
            System.out.println("Пользователь " + username + " не найден!");
        }
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public Optional<User> getUserByUsername(String username) {
        return findUserByUsername(username);
    }

    public boolean userExists(String username) {
        return findUserByUsername(username).isPresent();
    }

    private Optional<User> findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public String getUserInput() {
        System.out.print("Введите команду: ");
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
