package com.luv2code.springdemo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  //Need to inject the customer service
  //Spring will scan for a component that implements CustomerService interface
  @Autowired 
  private CustomerService customerService; 
  
  @GetMapping("/list")
  public String listCustomers(Model theModel) {
    
    //get customers from the service
    List<Customer> theCustomers = customerService.getCustomers();
    
    //add the customers to the model
    theModel.addAttribute("customers", theCustomers);
    
    return "list-customers";
  }
  
  //Create method to return form for adding customer
  
  @GetMapping("/showFormForAdd")
  public String showFormForAdd( Model theModel){
    return "customer-form";
  }
  
}









