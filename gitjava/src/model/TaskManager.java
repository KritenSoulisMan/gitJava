package model;

import java.util.*;

public class TaskManager
{
    private List<Task> tasks;

    public TaskManager()
    {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index)
    {
        if (index >= 0 && index < tasks.size())
        {
            tasks.remove(index);
        } else {
            System.out.println("Неверный индекс задачи");
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTask(int id)
    {
        if (id >= 0 && id < tasks.size())
        {
            return tasks.get(id);
        }
        else
        {
            System.out.println("Неверный индекс задачи");
            return null;
        }
    }

    public Task getTask(String key)
    {
        for (Task task : tasks)
        {
            if (task.getKey().equals(key))
            {
                return task;
            }
        }
        return null;
    }

    public void updateTask(int index, Task updatedTask)
    {
        if (index >= 0 && index < tasks.size())
        {
            tasks.set(index, updatedTask);
        }
        else
        {
            System.out.println("Неверный индекс задачи");
        }
    }

    public int getTaskCount() {
        return tasks.size();
    }

    // Метод для фильтрации задач по всем полям с использованием HashMap
    public List<Task> filterTasks(HashMap<String, String> filters)
    {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks)
        {
            boolean match = true;
            for (String key : filters.keySet())
            {
                String value = filters.get(key);
                switch (key)
                {
                    case "summary":
                        if (!task.getSummary().contains(value))
                        {
                            match = false;
                        }
                        break;
                    case "description":
                        if (!task.getDescription().contains(value))
                        {
                            match = false;
                        }
                        break;
                    case "creator":
                        if (!task.getCreator().equals(value))
                        {
                            match = false;
                        }
                        break;
                    case "assignee":
                        if (!task.getAssignee().equals(value))
                        {
                            match = false;
                        }
                        break;
                    case "supervisor":
                        if (!task.getSupervisor().equals(value))
                        {
                            match = false;
                        }
                        break;
                    case "user":
                        if (!(task.getCreator().equals(value) || task.getAssignee().equals(value) || task.getSupervisor().equals(value)))
                        {
                            match = false;
                        }
                        break;
                    default:
                        break;
                }
            }
            if (match)
            {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    // Метод для сортировки задач по дате создания
    public void sortTasksByCreateDate()
    {
        tasks.sort(Comparator.comparing(Task::getCreateDate));
    }

    // Метод для сортировки задач по дате завершения
    public void sortTasksByDueDate()
    {
        tasks.sort(Comparator.comparing(Task::getDueDate));
    }

    // Метод для сортировки задач по статусу завершения
    public void sortTasksByCompletion()
    {
        tasks.sort(Comparator.comparing(Task::isCompleted));
    }

    // Метод для вывода всех задач
    public void printTasks()
    {
        // Цикл for-each
        for (Task task : tasks)
        {
            // Метод toString для строкового представления задачи
            System.out.println(task);
        }
    }

    // Метод для описания задачи по ее индексу
    public void describeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            System.out.println("Описание задачи:");
            System.out.println("Краткое описание: " + task.getSummary());
            System.out.println("Подробное описание: " + task.getDescription());
        } else {
            System.out.println("Неверный индекс задачи");
        }
    }
}
