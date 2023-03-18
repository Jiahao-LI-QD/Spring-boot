package com.example.demo.customer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    public void createNewCustomer(@RequestBody @Valid Customer customer){
        System.out.println("Post Request...");
        System.out.println(customer);
    }

    @PutMapping
    public void updateNewCustomer(@RequestBody Customer customer){
        System.out.println("Update Request...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("Delete Request with id : " + id);
    }
}
