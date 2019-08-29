package hello.repository;

import java.util.List;
import java.util.Optional;

import hello.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();
    List<Customer> findByLastName(String lastName);

    void deleteById(Long id);
    void deleteByLastName(String lastName);

    //TODO: Add code that will be necessary to implement all methods in service
}
