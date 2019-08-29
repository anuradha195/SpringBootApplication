package hello.servce;

import hello.dto.CustomerDto;
import hello.mapper.CustomerMapper;
import hello.model.Customer;
import hello.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    protected CustomerMapper mapper;
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public List<Customer> getAllCustomers() {
        //return customerRepository.findAll();
        List<Customer> result = (List<Customer>) customerRepository.findAll();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Customer>();
        }
    }

    //TODO: Implement methods for each controller method. Note that each of them has to call different method from Service.
    //Get customer by ID
    public Customer getCustomerById(Long id) throws Exception
    {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }//end of getCustomerById method


    //Get Customer by Lastname
    public Iterable<Customer> getCustomerByLastName(String name) throws Exception {

       //return customerRepository.findByLastName(name);
        return customerRepository.findByLastName(name);

    } // end of getCustomerByLastName

    //createOrUpdateEmployee
    public Customer createOrUpdateCustomer(Customer customer)
    {
        if(customer.getId()  == null)
        {
            customer = customerRepository.save(customer);

            return customer;
        }
        else
        {
            Optional<Customer> cust = customerRepository.findById(customer.getId());

            if(cust.isPresent())
            {
                Customer newEntity = cust.get();
                newEntity.setId(customer.getId());
                newEntity.setFirstName(customer.getFirstName());
                newEntity.setLastName(customer.getLastName());

                newEntity = customerRepository.save(newEntity);

                return newEntity;
            } else {
                customer = customerRepository.save(customer);

                return customer;
            }
        }
    }

    //Save Customer Details
    /*public long saveCustomer(CustomerDto customerDto) {

        Customer customer = mapper.toEntity(customerDto);
        customer.setId(customer.getId());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customerRepository.saveCustomer(customer);
        return customer.getId();
    } */

    public void deleteById(Long id) throws Exception
    {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent())
        {
            customerRepository.deleteById(id);
        } else {
            throw new Exception("No Such Record exist for given id");
        }
    }

    public void deleteEmployeeByLastName(String lastName) throws Exception {
        List<Customer> customer = customerRepository.findByLastName(lastName);
        if(!customer.isEmpty())
        {
            customerRepository.deleteByLastName(lastName);
        } else {
            throw new Exception("No Such Record exist for given LastName");
        }

    }

}
