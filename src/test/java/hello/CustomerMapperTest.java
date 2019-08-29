package hello;

import hello.dto.CustomerDto;
import hello.mapper.CustomerMapper;
import hello.model.Customer;
import hello.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class CustomerMapperTest {

    @Autowired
    private CustomerMapper mapper = new CustomerMapper();

    @Before
    public void setUp() throws Exception {
        CustomerMapper mapper= new CustomerMapper();
    }

    @Test
    public void toDtoTest(){
        Customer cust= setUpCustomer();
        CustomerDto dto= mapper.toDto(cust);
        assertDto(dto);
    }

    @Test
    public void toEntityTest(){
        CustomerDto dto= setUpDto();
        Customer cust= mapper.toEntity(dto);
        Assert.assertEquals("Anu",cust.getFirstName());
        Assert.assertEquals("Radha",cust.getLastName());
    }

    @Test
    public void toDtoListTest() {
        List<CustomerDto> dto = mapper
                .toDtoList(Collections.singletonList(setUpCustomer()));
        Assert.assertEquals(1, dto.size());
    }

    @Test
    public void toEntityListTest(){
        List<Customer> cust = mapper
                .toEntityList(Collections.singletonList(setUpDto()));
        Assert.assertEquals(1, cust.size());

    }

    @Test
    public void updateEntityDataTest(){
        Customer cust=new Customer("Anu","Radha");
        CustomerDto dto=setUpDto();
        Assert.assertEquals(cust,mapper.updateEntityData(cust,dto));
    }

    private Customer setUpCustomer(){
        Customer cust = new Customer();
        cust.setId(10L);
        cust.setFirstName("Anu");
        cust.setLastName("Radha");
        return cust;
    }

    private CustomerDto setUpDto(){
        CustomerDto dto = new CustomerDto();
        dto.setId(10L);
        dto.setFirstName("Anu");
        dto.setLastName("Radha");

        return dto;
    }

    private void assertDto(CustomerDto dto) {
        Assert.assertNotNull(dto);
        Assert.assertEquals("Anu", dto.getFirstName());
        Assert.assertEquals("Radha", dto.getLastName());
    }


}
