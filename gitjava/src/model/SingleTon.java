package model;

public class SingleTon
{
    // Статическая переменная для хранения единственного экземпляра
    private static SingleTon instance;


    private SingleTon()
    {
        // Приватный конструктор, чтобы предотвратить создание других экземпляров
    }


    // Публичный статический метод для получения экземпляра Singleton
    public static SingleTon getInstance()
    {
        if (instance == null)
        {
            synchronized (SingleTon.class)
            { // Синхронизация для потокобезопасности
                if (instance == null)
                {
                    instance = new SingleTon(); // Инициализация экземпляра
                }
            }
        }
        return instance; // Возвращаем единственный экземпляр
    }

    // Пример метода в Singleton
    public void exampleMethod() { System.out.println("This is an example method in Singleton."); }
}
