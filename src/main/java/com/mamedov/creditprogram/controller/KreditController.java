package com.mamedov.creditprogram.controller;

import com.mamedov.creditprogram.dto.CreditDTO;
import com.mamedov.creditprogram.entities.Client;
import com.mamedov.creditprogram.entities.Credit;
import com.mamedov.creditprogram.services.ClientServiceImpl;
import com.mamedov.creditprogram.services.CreditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.BinaryOperator;

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
//    @GetMapping("/newclient")
//    public String addClientView(Model model){
//        model.addAttribute("client",new Client());
//        return "new_client";
//    }
//    @GetMapping("/client")
//    public String getClients(Model model){
//        model.addAttribute("clients",clientService.getAllClients());
//        return "clients";
//    }
//    @GetMapping("/client/{clid}")
//    public String clientDetails(@PathVariable("clid")int id,Model model){
//        Client client=clientService.getClientById(id);
//        model.addAttribute("client",client);
//        return "client_details";
//    }
//    @PostMapping("/client")
//    public String addClientDB(@ModelAttribute("client") Client client,Model model){
//        clientService.saveClient(client);
//        List<Client> clients=clientService.getAllClients();
//        model.addAttribute("clients",clients);
//        return "clients";
//    }
    @GetMapping("/new")
    public String newCreditView(Model model) {
        model.addAttribute("credit", new Credit());
        return "new_credit";
    }
    @PostMapping("/new")
    public String addCreditDB(@Valid @ModelAttribute("credit") Credit credit, BindingResult bindingResult,@RequestParam("musteri_id") int id){

        Client client=clientService.getClientById(id);
        if (bindingResult.hasErrors()) return "new_credit";
        Date baslamaTarixi=new java.sql.Date(Calendar.getInstance().getTime().getTime());
        LocalDate localDate=baslamaTarixi.toLocalDate().plusMonths(credit.getKreditinMuddeti());
        Date bitmeTarixi=Date.valueOf(localDate);
        credit.setKreditinBitmeTarixi(bitmeTarixi);
        credit.setClient(client);
        credit.setKreditinBaslamaTarixi(baslamaTarixi);
        credit.setAnaMebleg(credit.getKreditMeblegi());
        client.addCredit(credit);
        creditService.saveCredit(credit);
        return "redirect:home";
    }
}
