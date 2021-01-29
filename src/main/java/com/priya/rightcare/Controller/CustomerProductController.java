package com.priya.rightcare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.rightcare.DTO.CustomerOrderRequest;
import com.priya.rightcare.DTO.CustomerOrderResponse;
import com.priya.rightcare.Entity.Customer;
import com.priya.rightcare.Entity.Product;
import com.priya.rightcare.Repository.CartRepository;
import com.priya.rightcare.Repository.CustomerRepository;
import com.priya.rightcare.Service.CustomerService;
import com.priya.rightcare.Service.ProductService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CustomerProductController {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;

	
	@GetMapping("")
	public Customer registerCustomer(@RequestBody Customer customer) throws Exception {
		String tempEmailId = customer.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {

			Customer custom = customerService.fetchCustomerByEmailId(tempEmailId);
			if (custom != null) {
				throw new Exception("Customer with " + tempEmailId + " is already exists");
			}
		}
		Customer cutom = null;
		cutom = customerService.saveCustomer(customer);
		return cutom;

	}
	@PostMapping("/register")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
		
	}
	

	@GetMapping("/Getcustomer/{CustomerId}")
	public Customer findById(@PathVariable int CustomerId) {
		return customerService.getById(CustomerId);

	}

	@GetMapping("/getcustomer/{firstname}")
	public Customer findByCustomerfirstName(@PathVariable String firstName) {
		return customerService.getByfirstName(firstName);

	}

    @PostMapping("/placeorder")
	public Customer placeOrder(@RequestBody CustomerOrderRequest customerorder) {

		return customerRepository.save(customerorder.getCustomer());
	}

	@GetMapping("/findallorders")
	public List<Customer> findAllOrders() {

		return customerRepository.findAll();
	}

	@GetMapping("/orderdetail")
	public List<CustomerOrderResponse> getOrderDetails() {

	return customerRepository.getOrderDetails();
	}
	@GetMapping("/allproducts/{productId}")
	public Product findAllById(@PathVariable int productId ){
		
		return productService.getById(productId);
		
	}
	
	@GetMapping("/findproduct/{productId}")
	public Product findByproductId(@PathVariable int productId ){
		
		return productService.getById(productId);
		
	}
	

}
