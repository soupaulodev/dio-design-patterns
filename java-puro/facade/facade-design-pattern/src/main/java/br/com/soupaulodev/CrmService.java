package br.com.soupaulodev;

public class CrmService {

    private CrmService() {
        super();
    }

    public static void saveClient(String name, String cep, String city, String state) {
        System.out.println("Client " + name + " saved with address " + cep + ", " + city + ", " + state);
    }

}
