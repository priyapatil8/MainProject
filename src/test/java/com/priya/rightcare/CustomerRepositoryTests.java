package com.priya.rightcare;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.priya.rightcare.Entity.Customer;
import com.priya.rightcare.Repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE )
@Rollback(false)
public class CustomerRepositoryTests {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateCustomer() {
		
		Customer customer = new Customer();
		
		customer.setEmailId("arnabh@gmail.com");
		customer.setFirstName("Arnabh");
		customer.setLastName("Mukharji");
		customer.setAddress("Mumbai");
		customer.setPhoneNum(456734298);
		customer.setZipCode(1234);
		Customer savedCustomer = customerRepository.save(customer);
		
		Customer existCustomer = entityManager.find(Customer.class, savedCustomer.getCustomerId());
		assertThat(existCustomer.getEmailId()).isEqualTo(customer.getEmailId());
	}
    
	
}
