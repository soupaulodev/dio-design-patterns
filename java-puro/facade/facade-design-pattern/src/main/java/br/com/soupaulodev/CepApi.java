package br.com.soupaulodev;

public class CepApi {
    private static final CepApi instance = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstance() {
        return instance;
    }
    
    public String getAddress(String cep) {
        System.out.println("Getting address for CEP " + cep);
        return "Address for CEP " + cep;
    }
}
