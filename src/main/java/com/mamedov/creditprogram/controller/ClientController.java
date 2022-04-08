package com.mamedov.creditprogram.controller;

import com.mamedov.creditprogram.entities.Client;
import com.mamedov.creditprogram.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/new")
    public String addClientView(Model model) {
        model.addAttribute("client", new Client());
        return "new_client";
    }

    @GetMapping("/")
    public String getClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/{id}")
    public String clientDetails(@PathVariable("id") int id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "client_details";
    }

    @RequestMapping(value ="/",method = RequestMethod.POST)
    public String addClientDB(@Valid @ModelAttribute("client")  Client client ,BindingResult bindingResult, Model model) {
        if(bindingResult.hasFieldErrors()){
            System.out.println("hm");
            return "new_client";
        }
            System.out.println("else");
            clientService.saveClient(client);
            List<Client> clients = clientService.getAllClients();
            model.addAttribute("clients", clients);
            return "clients";

    }
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable("id")int id){
        clientService.deleteClientById(id);
        return "redirect:/client/";
    }
}