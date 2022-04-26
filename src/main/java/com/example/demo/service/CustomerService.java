package com.example.demo.service;

import javax.websocket.server.ServerEndpoint;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.document.Customer;
import com.example.demo.document.Hotel;
import com.example.demo.document.Login;
import com.example.demo.repo.CustomerDetails;

@Service
public class CustomerService {
	@Autowired
	CustomerDetails customerRepo;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public Customer setCustomerDetails(Customer customer) {
		if ((customer.getEmail() != null && customer.getEmail() != "")
				&& (customer.getPassword() != null && customer.getPassword() != "")) {
			if (customer.getEmail().contains("@")
					&& (customer.getPassword().length() >= 6 && customer.getPassword().length() <= 20)) {
				String encrypted = encoder.encode(customer.getPassword());
				customer.setPassword(encrypted);
				return customerRepo.save(customer);
			}
		}
		return new Customer();
	}

	public Customer getCustomerByEmail(Login login) {

		Optional<Customer> customer = customerRepo.findByEmail(login.getEmail());
		if (customer.isPresent()) {
			if (encoder.matches(login.getPassword(), customer.get().getPassword())) {
				return customer.get();
			} else {
				return new Customer();
			}
		} else {
			return new Customer();
		}
	}

	public Customer getCustomerById(String id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			return new Customer();
		}
	}
	
	public List<Customer> getAllCustomers() {
		List<Customer> customer = customerRepo.findAll();
		if(customer.isEmpty()) {
			return null;
		}
		else {
			return customer;
		}
	}

}
