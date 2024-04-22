package model;

import model.userSettings.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task
{
    private String creator;
    private String assignee;
    private String supervisor;
    private String summary; // Переменная для хранения краткого описания задачи
    private String description; // Переменная для хранения подробного описания задачи
    private Date createDate; // Переменная для хранения даты создания задачи
    private Date dueDate; // Переменная для хранения даты завершения задачи
    private boolean completed; // Переменная для отслеживания статуса завершения задачи
    {this.completed = false;} // По умолчанию задача не завершена
    private int ID; // id из БД (нужен геттор)
    private String Key;

    // Конструктор класса, принимающий переменные
    public Task(String summary, String description, Date createDate, Date dueDate, String creator, String assignee, String supervisor)
    {
        // Инициализация полей класса значениями, переданными через параметры конструктора
        this.summary = summary;
        this.description = description;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.creator = creator;
        this.assignee = assignee;
        this.supervisor = supervisor;

    }

    public String getCreator()
    {
        return creator;
    }

    public String getAssignee()
    {
        return assignee;
    }

    public String getSupervisor()
    {
        return supervisor;
    }

    //
    public int getID()
    {
        return ID;
    }

    //
    public String getKey()
    {
        return Key;
    }

    // Метод для пометки задачи как завершенной
    public void markAsCompleted()
    {
        this.completed = true; // Установка статуса завершения задачи в true
    }

    // Геттер для получения краткого описания задачи
    public String getSummary()
    {
        return summary;
    }

    // Сеттер для установки краткого описания задачи
    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    // Геттер для получения подробного описания задачи
    public String getDescription()
    {
        return description;
    }

    // Сеттер для установки подробного описания задачи
    public void setDescription(String description)
    {
        this.description = description;
    }

    // Геттер для получения даты создания задачи
    public Date getCreateDate()
    {
        return createDate;
    }

    // Сеттер для установки даты создания задачи
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    // Геттер для получения даты завершения задачи
    public Date getDueDate()
    {
        return dueDate;
    }

    // Сеттер для установки даты завершения задачи
    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    // Геттер для получения статуса завершения задачи
    public boolean isCompleted()
    {
        return completed;
    }

    // Сеттер для установки статуса завершения задачи
    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public String getTitle()
    {
        return summary;
    }
    public void setAssignee(User user) { this.assignee = user.getUsername(); }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Название: ").append(summary).append("\n");
        sb.append("Описание: ").append(description).append("\n");
        sb.append("Дата создания: ").append(formatDate(createDate)).append("\n");
        sb.append("Дата завершения: ").append(formatDate(dueDate)).append("\n");
        sb.append("Создатель: ").append(creator).append("\n");
        sb.append("Назначенный: ").append(assignee).append("\n");
        sb.append("Надзиратель: ").append(supervisor).append("\n");
        sb.append("Статус: ").append(completed ? "Завершено" : "Не завершено").append("\n");
        return sb.toString();
    }

    private String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            return sdf.format(date);
        } else {
            return "Не задана";
        }
    }
}
