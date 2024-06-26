package br.com.paulodev;

/**
 * Singleton Eager "apressado"
 * 
 * @author paulo
 *
 */
public class SingletonEager {

    private static final SingletonEager INSTANCE = new SingletonEager();

    private SingletonEager() {
        super();
    }

    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}
