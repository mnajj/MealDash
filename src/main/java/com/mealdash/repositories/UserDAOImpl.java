package com.mealdash.repositories;

import com.mealdash.entities.User;
import com.mealdash.interfaces.dao.UserDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


	private final SessionFactory sessionFactory;

	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getAllUsers() {
		var session = sessionFactory.getCurrentSession();
		return session
						.createQuery("from users order by lastName", User.class)
						.getResultList();
	}
}
