package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Client;
import com.mamedov.creditprogram.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientServiceInter{
    @Autowired
    private ClientRepo clientRepo;
    @Override
    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public Client getClientById(int id) {
        return clientRepo.findById(id).get();
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }
}
