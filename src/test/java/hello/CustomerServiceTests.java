package hello;

import hello.model.Customer;
import hello.repository.CustomerRepository;
import hello.servce.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTests {
    @Autowired
    private TestEntityManager entityManager;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService service;

    @Test
    public void searchByLastName() throws Exception {
        // CustomerRepository customerRepository = new CustomerRepository();


        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Daniel","Radcliff"));
        /*customers.add(new Customer("Jack", "Bauer"));
        customers.add(new Customer("Chloe", "O'Brian"));
        customers.add(new Customer("Kim", "Bauer"));
        customers.add(new Customer("David", "Palmer"));
        customers.add(new Customer("Michele", "Dessler"));*/

        long id=6;
        //when(customerRepository.findAll()).thenReturn(customers);
        when(customerRepository.findByLastName(anyString())).thenReturn(customers);
        // Customer customer = new Customer("Jovial","Minsky");
        // customer.setId(id);
        // service.getCustomerByLastName();

        List<Customer> customerList = customerRepository.findByLastName("Radcliff");
        Iterable<Customer> customerList1 = service.getCustomerByLastName("Radcliff");
        Assert.assertEquals(1,customerList.size());
        int counter = 0;
        for (Object i : customerList1) {
            counter++;
        }
        Assert.assertEquals(1,counter);
    }

    @Test
    public void searchAllCustomers() throws Exception{
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jack", "Bauer"));
        customers.add(new Customer("Chloe", "O'Brian"));
        customers.add(new Customer("Kim", "Bauer"));
        customers.add(new Customer("David", "Palmer"));
        customers.add(new Customer("Michele", "Dessler"));
        //when(customerRepository.findAll()).thenReturn(customers);
        Assert.assertEquals(5,customers.size());
    }

    @Test
    public void searchCustomerByID() throws Exception{
        long id1=1;

        Customer customer1 = new Customer("Jack","Daniel");
        Customer customer2 = new Customer("Jovial","Minsky");

        HashMap<Integer,Customer> repo = new HashMap<>();
        repo.put(1,customer1);
        repo.put(2,customer2);
        //when(customerRepository.findById(1)).thenReturn(Optional.of((customer1)));
        Assert.assertEquals("Jack", customer1.getFirstName());
    }

    @Test
    public void checkWhetherTheCustomerIsUpdatedOrNot() throws Exception{
        Customer customer1 = new Customer("Jack","Robbinson");
        when(service.createOrUpdateCustomer(customer1)).thenReturn(customer1);
        Assert.assertEquals("Jack",customer1.getFirstName());
        Assert.assertEquals("Robbinson",customer1.getLastName());
    }

}
