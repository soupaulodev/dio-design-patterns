package br.com.soupaulodev.design_patterns_spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.soupaulodev.design_patterns_spring.model.Adress;
import br.com.soupaulodev.design_patterns_spring.model.AdressRepository;
import br.com.soupaulodev.design_patterns_spring.model.Client;
import br.com.soupaulodev.design_patterns_spring.model.ClientRepository;
import br.com.soupaulodev.design_patterns_spring.service.ClientService;
import br.com.soupaulodev.design_patterns_spring.service.ViaCepService;

/**
 * Implementação do <b>Strategy</b> {@link ClientService}, a qual pode ser injetada pelo Sping (via {@link Autowired}). Com isso, como essa classe é um {@link Service}, ela será tratada com um <b>Singleton</b>.
 * 
 * @author soupaulodev
 */
@Service
public class ClientServiceImpl implements ClientService {

    // Singleton: Injetar os componentes do Spring com @Autowired
    @Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AdressRepository adressRepository;
	@Autowired
	private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integracões com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        String cep = client.getAdress().getCep();
        Adress adress = adressRepository.findById(cep).orElseGet(() -> {
            Adress newAdress = viaCepService.getAddressByCep(cep);
            adressRepository.save(newAdress);
            return newAdress;
        });

        client.setAdress(adress);
        clientRepository.save(client);

        return;
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientDb = clientRepository.findById(id);

        if (clientDb.isPresent()) {
            clientDb.get().setName(client.getName());
            clientDb.get().setAdress(client.getAdress());
            clientRepository.save(clientDb.get());
        }

        return;
    }

    @Override
    public void delete(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if (!client.isPresent()) {
            return;
        }

        clientRepository.delete(client.get());
        return;
    }

}
