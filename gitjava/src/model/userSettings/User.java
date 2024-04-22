package model.userSettings;

public class User
{
    private static User instance;
    private int id;
    private String login;
    private int companyId;
    private int departmentId;
    private String username;

    public User(String username)
    {
        this.username = username;
    }

    public User(int id, String login, int companyId, int departmentId, String username)
    {
        this.id = id;
        this.login = login;
        this.companyId = companyId;
        this.departmentId = departmentId;
        this.username = username;
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User(0, "", 0, 0, "");
        }
        return instance;
    }

    public static User createNewUser(String login, int companyId, int departmentId, String username)
    {
        //todo Прочитать про шаблон SingleTon.
        // (Создание объектов для жизни в одном экземпляре)
        //.................................................................
        //todo Пока-что типо заглушки.
        instance = new User(0, login, companyId, departmentId, username);
        return instance;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public int getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(int companyId)
    {
        this.companyId = companyId;
    }

    public int getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(int departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", companyId=" + companyId +
                ", departmentId=" + departmentId +
                ", username='" + username + '\'' +
                '}';
    }

    public String getName()
    {
        return username;
    }
}
