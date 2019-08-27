package hello.mapper;

import hello.dto.CustomerDto;
import hello.model.Customer;
import hello.repository.CustomerRepository;
import org.modelmapper.ModelMapper;

public class CustomerMapper {

    protected CustomerRepository customerRepository;

    //TODO: Implement method that maps entity to dto
    /*public CustomerDto toDto(Customer customer){
        ModelMapper modelMapper = new ModelMapper();
        Customer cust = customerRepository.saveCustomer(customer);
        CustomerDto customerDto = modelMapper.map(cust, CustomerDto.class);

        return customerDto;
    } */

    //TODO: Implement method that maps dto to entity
      /* public Customer toEntity(CustomerDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(dto,Customer.class);
        return customer;
    } */

    //TODO: Implement method that maps List of entities to List of dto

    //TODO: Implement method that maps List of dto to List of entities

    //TODO: Implement method that updates entity with dto data
}
