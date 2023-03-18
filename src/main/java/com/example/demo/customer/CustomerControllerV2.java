package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customer")
@AllArgsConstructor
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    public Customer getCustomerException(@PathVariable("customerId") Long id){
        throw new ApiRequestException(
                "ApiRequestException for customer " + id);
    }

    @PostMapping
    public void createNewCustomer(@RequestBody @Valid Customer customer){
        System.out.println("Post Request...");
        System.out.println(customer);
    }

    @PutMapping
    public void updateNewCustomer(@RequestBody @Valid Customer customer){
        System.out.println("Update Request...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("Delete Request with id : " + id);
    }
}
