package com.mealdash.services;

import com.mealdash.entities.User;
import com.mealdash.interfaces.dao.CustomerDAO;
import com.mealdash.interfaces.services.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDAO customerDAO;

	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<User> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}
}
