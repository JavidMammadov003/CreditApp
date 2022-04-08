package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Client;

import java.util.List;

public interface ClientServiceInter {
     void saveClient(Client client);
     Client getClientById(int id);
     List<Client> getAllClients();
     void deleteClientById(int id);

}
