package Patterns;
public class Singleton {
    private static Singleton instance;
    private Singleton() {
        // private: only this class can call this constructor
    }
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public static class Main {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a == b); // true — same object
    }
}
}
