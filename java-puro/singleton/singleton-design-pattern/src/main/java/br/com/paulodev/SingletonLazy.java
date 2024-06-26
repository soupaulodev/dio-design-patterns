package br.com.paulodev;

/**
 * Singleton Lazy "preguicoso"
 * 
 * @author paulo
 *
 */

public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
