package br.com.paulodev;

/**
 * Singleton "Lazy Holder"
 * 
 * @author paulo
 *
 */
public class SingletonLazyHolder {
    private static class InstanceHolder {
        public static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
        super();
    }
    
    public static SingletonLazyHolder getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
