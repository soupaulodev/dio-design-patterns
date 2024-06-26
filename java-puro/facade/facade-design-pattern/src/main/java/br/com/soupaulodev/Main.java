package br.com.soupaulodev;

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.migrateClient("John", "12345678");
    }
}