package com.mamedov.creditprogram.controller;

import com.mamedov.creditprogram.entities.Client;
import com.mamedov.creditprogram.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/newclient")
    public String addClientView(Model model) {
        model.addAttribute("client", new Client());
        return "new_client";
    }

    @GetMapping("/client")
    public String getClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/client/{id}/details")
    public String clientDetails(@PathVariable("id") int id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client_details";
    }

    @PostMapping("/client")
    public String addClientDB(@ModelAttribute("client") Client client, Model model) {
        clientService.saveClient(client);
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "clients";
    }
}