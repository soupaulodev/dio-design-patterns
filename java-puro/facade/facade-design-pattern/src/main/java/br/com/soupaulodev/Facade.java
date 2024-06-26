package br.com.soupaulodev;

public class Facade {
    
    public void migrateClient(String name, String cep) {
        CepApi cepApi = CepApi.getInstance();
        String city = cepApi.getAddress(cep);
        CrmService.saveClient(name, cep, city, "SP");
        
        System.out.println("Client " + name + " migrating to address " + cep);
    }
}
