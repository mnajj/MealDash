package com.mealdash.interfaces.dao;

import com.mealdash.entities.User;

import java.util.List;

public interface CustomerDAO {
	List<User> getAllCustomers();
}
