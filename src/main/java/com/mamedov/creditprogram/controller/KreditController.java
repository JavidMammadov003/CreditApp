package com.mamedov.creditprogram.controller;

import com.mamedov.creditprogram.entities.Client;
import com.mamedov.creditprogram.entities.Credit;
import com.mamedov.creditprogram.services.CreditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KreditController {
    @Autowired
    private CreditServiceImpl service;
    @GetMapping("credit")
    public String getCredits(Model model){
        List<Credit> credits=service.getCredits();
        model.addAttribute("credits",credits);
        return "credit_page";
    }
    @GetMapping("newclient")
    public String addClient(Model model){
        model.addAttribute("client",new Client());
        return "credit";
    }
    @PostMapping("credit")
    public String showAll(@ModelAttribute Client client){
        service.
    }
}
