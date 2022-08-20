package com.mealdash.interfaces.dao;

import com.mealdash.entities.User;

import java.util.List;

public interface UserDAO {
	List<User> getAllUsers();

	User getUserById(int id);
}
