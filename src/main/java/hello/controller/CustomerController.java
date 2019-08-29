package hello.controller;


import hello.dto.CustomerDto;
import hello.model.Customer;
import hello.repository.CustomerRepository;
import hello.servce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@SessionAttributes("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    CustomerRepository repo;


    //TODO: All logic has to be implemented in service!

    //TODO: Create GET method that retrieves all customers
     @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Customer>> getAllCustomers(Model model){
        List<Customer> list=customerService.getAllCustomers();
        return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /*
    @GetMapping({"/customers","/all"})
    public String findAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    } */




    //TODO: Create GET method that gets customer by its ID

    @GetMapping("/findCustomerById/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) throws Exception {
        Customer customerById = customerService.getCustomerById(id);
        return new ResponseEntity<Customer>(customerById, new HttpHeaders(), HttpStatus.OK);
    }

    //TODO: Create GET method that gets customer by search key (name, surname, etc.)

    @GetMapping("/findCustomerByLastName/{name}")
    @ResponseBody
    public Iterable<Customer> findCustomersByLastName(@PathVariable("name") String name) throws Exception {
        return customerService.getCustomerByLastName(name);
    }

    //TODO: Create POST method to saves new customer
    @PostMapping
    public ResponseEntity<Customer> createOrUpdatecustomer(Customer customer)
            throws Exception {
        Customer updated = customerService.createOrUpdateCustomer(customer);
        return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);
    }


    //TODO: Create PUT method to update existing customer. Note! If user tries to update not existing customer, throw an exception


    //TODO: Create DELETE method that deletes customer by id
    @RequestMapping(path = "/deleteById/{id}")
    public String deleteById(Model model, @PathVariable("id") Long id)
            throws Exception
    {
        customerService.deleteById(id);
        return "/all";
    }

    //TODO: Create DELETE method that deletes customer by any other key
    @RequestMapping(path = "/deleteByLastName/{name}")
    public String deletecustomerByLastName(Model model, @PathVariable("name") String lastName) throws Exception
    {
        customerService.deletecustomerByLastName(lastName);
        return "/all";
    }

}
