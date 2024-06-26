package br.com.paulodev;

public class Main {
    public static void main(String[] args) {
        SingletonLazy lazy = SingletonLazy.getInstance();
        SingletonLazy lazy2 = SingletonLazy.getInstance();
        System.out.println("As duas instâncias de Singleton Lazy são iguais? "+(lazy == lazy2 ? "Sim" : "Não"));

        SingletonEager eager = SingletonEager.getInstance();
        SingletonEager eager2 = SingletonEager.getInstance();
        System.out.println("As duas instâncias de Singleton Eager são iguais? "+ (eager == eager2 ? "Sim" : "Não"));

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstance();
        SingletonLazyHolder lazyHolder2 = SingletonLazyHolder.getInstance();
        System.out.println("As duas instâncias de Singleton Lazy Holder são iguais? "+(lazyHolder == lazyHolder2 ? "Sim" : "Não"));
    }
}