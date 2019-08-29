/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hello;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import hello.model.Customer;
import hello.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customers;

    @Test
    public void testFindByLastName() {
        Customer customer = new Customer("first", "last");
        entityManager.persist(customer);
        List<Customer> findByLastName = customers.findByLastName(customer.getLastName());
        assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
    }

    @Test
    public void searchWhenCustomersExistInDatabaseDuringStartById(){
        List<Customer> customerList = customers.findAll();
        Assert.assertEquals(5,customerList.size());
    }

    @Test
    public void searchWhenCustomerIsDeletedById(){
        long id = 2;
        customers.deleteById(id);
        List<Customer> customerList = customers.findAll();
        Assert.assertEquals(4,customerList.size());
    }

    @Test
    public void searchWhenCustomerIsDeletedByName(){
        String lastName = "Dessler";
        customers.deleteByLastName(lastName);
        List<Customer> customer = customers.findByLastName(lastName);
        Assert.assertEquals(0,customer.size());
    }


}
