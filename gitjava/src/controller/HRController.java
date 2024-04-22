package controller;

import model.Task;
import model.userSettings.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HRController
{
    private List<Task> tasks;
    private List<User> users;

    public HRController()
    {
        this.tasks = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addTask(Task task)
    {
        tasks.add(task);
        System.out.println("Задача \"" + task.getTitle() + "\" успешно добавлена.");
    }

    public void removeTask(Task task)
    {
        if (tasks.remove(task))
        {
            System.out.println("Задача \"" + task.getTitle() + "\" успешно удалена.");
        }
        else
        {
            System.out.println("Задача \"" + task.getTitle() + "\" не найдена.");
        }
    }

    public void assignTask(Task task, String username)
    {
        // Находим пользователя по его имени
        Optional<User> userOptional = findUserByUsername(username);

        // Если пользователь найден, назначаем задачу
        if (userOptional.isPresent())
        {
            User user = userOptional.get();
            if (tasks.contains(task))
            {
                task.setAssignee(user);
                System.out.println("Задача \"" + task.getTitle() + "\" успешно назначена сотруднику " + user.getUsername() + ".");
            }
            else
            {
                System.out.println("Задача \"" + task.getTitle() + "\" не найдена.");
            }
        }
        else
        {
            System.out.println("Пользователь с именем \"" + username + "\" не найден.");
        }
    }

    private Optional<User> findUserByUsername(String username)
    {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public void removeAssignment(Task task, String assigneeUsername)
    {
        Optional<User> userOptional = findUserByUsername(assigneeUsername);
        if (tasks.contains(task))
        {
            if (userOptional.isPresent())
            {
                User assignee = userOptional.get();
                task.setAssignee(null);
                System.out.println("Назначение задачи \"" + task.getTitle() + "\" для сотрудника " + assignee.getUsername() + " успешно удалено.");
            }
            else
            {
                System.out.println("Пользователь с именем \"" + assigneeUsername + "\" не найден.");
            }
        }
        else
        {
            System.out.println("Задача \"" + task.getTitle() + "\" не найдена.");
        }
    }

    public List<Task> getTasks()
    {
        return new ArrayList<>(tasks);
    }

    public List<User> getUsers()
    {
        return new ArrayList<>(users);
    }

    public Optional<User> findUserById(int id)
    {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public void addUser(User user)
    {
        users.add(user);
        System.out.println("Сотрудник " + user.getUsername() + " успешно добавлен.");
    }

    public void removeUser(User user)
    {
        if (users.remove(user))
        {
            System.out.println("Сотрудник " + user.getUsername() + " успешно удален.");
        }
        else
        {
            System.out.println("Сотрудник " + user.getUsername() + " не найден.");
        }
    }
}
