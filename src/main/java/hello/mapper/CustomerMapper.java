package hello.mapper;

import hello.dto.CustomerDto;
import hello.model.Customer;
import hello.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    protected CustomerRepository customerRepository;

    //TODO: Implement method that maps entity to dto
    public CustomerDto toDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        if(customer != null)
            BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    //TODO: Implement method that maps dto to entity
      public Customer toEntity(CustomerDto dto){
        //ModelMapper modelMapper = new ModelMapper();
        //Customer customer = modelMapper.map(dto,Customer.class);
        //return customer;
          Customer customer = new Customer();
          BeanUtils.copyProperties(dto, customer);
          return customer;
    }

    //TODO: Implement method that maps List of entities to List of dto
    public List<CustomerDto> toDtoList(List<Customer> customer) {

       /* List<Customer> customer_list = customerRepository.findAll();
       Type listType = new TypeToken<List<CustomerDto>>(){}.getType();
       List<CustomerDto> dtoList = new ModelMapper().map(customer_list,listType);
        return dtoList; */
        return customer.stream().map(this::toDto).collect(Collectors.toList());
    }

    //TODO: Implement method that maps List of dto to List of entities
    public List<Customer> toEntityList(List<CustomerDto> dtoList){
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    //TODO: Implement method that updates entity with dto data
    public Customer updateEntityData(Customer cust, CustomerDto dto){
        cust.setId(dto.getId());
        cust.setFirstName(dto.getFirstName());
        cust.setLastName(dto.getLastName());
        return cust;
    }

}
