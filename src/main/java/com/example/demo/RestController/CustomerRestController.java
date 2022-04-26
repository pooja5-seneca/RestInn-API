package com.example.demo.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.Customer;
import com.example.demo.document.Login;
import com.example.demo.service.CustomerService;
@CrossOrigin
@RestController

public class CustomerRestController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer/login")
	public ResponseEntity<Customer> loginDetails(@RequestBody Login login) {
	
		if(customerService.getCustomerByEmail(login).getEmail() == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		else {
			return ResponseEntity.of(Optional.of(customerService.getCustomerByEmail(login)));
		}
	}
	
	@PostMapping("/customer/registration")
	public ResponseEntity<Customer> customerRegistration(@RequestBody Customer customer) {
		Customer customer1 = customerService.setCustomerDetails(customer);
		if(customer1.getId() == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(customer1));
		}
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String id){
		Customer customer = customerService.getCustomerById(id);
		if(customer.getId()==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();			
		}
		else {
			return ResponseEntity.of(Optional.of(customer));
		}
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer> customer= customerService.getAllCustomers();
		if(customer==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(customer));
		}
	}
	
}
