package com.luv2code.springdemo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    //create model attribute to bind form data
    Customer theCustomer = new Customer();
    theModel.addAttribute("customer", theCustomer);
    
    return "customer-form";
  }
  
  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer theCustomer ){
    
    // save the customer using our service
    customerService.saveCustomer(theCustomer);
    
    //after adding customer redirect back to customer list page
    return "redirect:/customer/list";
  }
  
}









