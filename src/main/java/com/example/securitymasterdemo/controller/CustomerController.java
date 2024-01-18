package com.example.securitymasterdemo.controller;

import com.example.securitymasterdemo.dao.CustomerDao;
import com.example.securitymasterdemo.entity.Customer;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerDao customerDao;
    @GetMapping("/customer/save-customer")
    public String createCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }
    @PostMapping("customer/save-customer")
    public String processCustomer(@Valid Customer customer,
                                  BindingResult result){
        if (result.hasErrors()){
            return "customerForm";
        }
        customerDao.save(customer);
        return "redirect:/customer/list-customer";
    }
    @GetMapping("/customer/list-customer")
    public String listCustomer(Model model){
        model.addAttribute("customers",customerDao.findAll());
        return "customers";
    }
    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam("id") int id){
        customerDao.deleteById(id);
        return "redirect:/customer/list-customer";
    }
}
