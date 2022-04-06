package com.mamedov.creditprogram.controller;

import com.mamedov.creditprogram.dto.CreditDTO;
import com.mamedov.creditprogram.entities.Client;
import com.mamedov.creditprogram.entities.Credit;
import com.mamedov.creditprogram.services.ClientServiceImpl;
import com.mamedov.creditprogram.services.CreditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/credit")
public class KreditController {
    @Autowired
    private CreditServiceImpl creditService;
    @Autowired
    private ClientServiceImpl clientService;
    @GetMapping("/home")
    public String getCredits(Model model){
        List<CreditDTO> credits=new ArrayList<>();
        List<Credit> list= creditService.getAllCredits();
        for(Credit credit:list){
            CreditDTO dto=new CreditDTO(credit);
            credits.add(dto);
        }
        model.addAttribute("credits",credits);
        return "credit_page";
    }
    @GetMapping("/newclient")
    public String addClientView(Model model){
        model.addAttribute("client",new Client());
        return "new_client";
    }
    @PostMapping("/newclient")
    public String addClientDB(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:home";
    }
    @GetMapping("/newcredit")
    public String newCreditView(Model model){
        model.addAttribute("credit",new Credit());
        return "new_credit";
    }
    @PostMapping("/newcredit")
    public String addCreditDB(@ModelAttribute("credit") Credit credit, @RequestParam("musteri_id") int id){
        Client client=clientService.getClientById(id);
        Date bitmeTarixi=new java.sql.Date(Calendar.getInstance().getTime().getTime());
        LocalDate localDate=bitmeTarixi.toLocalDate().plusMonths(credit.getKreditinMuddeti());
        bitmeTarixi=Date.valueOf(localDate);
        credit.setKreditinBitmeTarixi(bitmeTarixi);
        credit.setClient(client);
        client.addCredit(credit);
        creditService.saveCredit(credit);
        return "redirect:home";
    }
}
