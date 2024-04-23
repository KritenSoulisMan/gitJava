package model;

import java.util.*;

public class TaskManager
{
    private List<Task> tasks;

    public TaskManager()
    {
        this.tasks = new ArrayList<>();
    }

    public boolean addTask(Task task)
    {
        return tasks.add(task);
    }

    public boolean removeTaskById(int id)
    {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext())
        {
            Task task = iterator.next();
            if (task.getId() == id)
            {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Task getTaskById(int id)
    {
        for (Task task : tasks)
        {
            if (task.getId() == id)
            {
                return task;
            }
        }
        return null;
    }

    public void updateTask(int id, Task updatedTask)
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            if (tasks.get(i).getId() == id)
            {
                tasks.set(i, updatedTask);
                return;
            }
        }
        System.out.println("Задача с ID " + id + " не найдена.");
    }

    public List<Task> getAllTasks()
    {
        return new ArrayList<>(tasks);
    }

    public int getTaskCount()
    {
        return tasks.size();
    }

    public List<Task> filterTasks(HashMap<String, String> filters)
    {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks)
        {
            boolean match = true;
            for (Map.Entry<String, String> entry : filters.entrySet())
            {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!matchesFilter(task, key, value))
                {
                    match = false;
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

    private boolean matchesFilter(Task task, String key, String value)
    {
        switch (key)
        {
            case "summary":
                return task.getSummary().contains(value);
            case "description":
                return task.getDescription().contains(value);
            case "creator":
                return task.getCreator().equals(value);
            case "assignee":
                return task.getAssignee().equals(value);
            case "supervisor":
                return task.getSupervisor().equals(value);
            case "user":
                return task.getCreator().equals(value) || task.getAssignee().equals(value) || task.getSupervisor().equals(value);
            default:
                return false;
        }
    }

    public void sortTasksById()
    {
        tasks.sort(Comparator.comparingInt(Task::getId));
    }

    public void sortTasksByCreateDate()
    {
        tasks.sort(Comparator.comparing(Task::getCreateDate));
    }

    public void sortTasksByDueDate()
    {
        tasks.sort(Comparator.comparing(Task::getDueDate));
    }

    public void sortTasksByCompletion()
    {
        tasks.sort(Comparator.comparing(Task::isCompleted));
    }

    public void printTasks()
    {
        for (Task task : tasks)
        {
            System.out.println(task);
        }
    }

    public void describeTaskById(int id)
    {
        Task task = getTaskById(id);
        if (task != null)
        {
            System.out.println("Описание задачи:");
            System.out.println("Краткое описание: " + task.getSummary());
            System.out.println("Подробное описание: " + task.getDescription());
        }
        else
        {
            System.out.println("Задача с ID " + id + " не найдена.");
        }
    }
}
