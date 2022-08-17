package com.mealdash.repositories;

import com.mealdash.entities.User;
import com.mealdash.interfaces.dao.CustomerDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	private final Session session;

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.session = sessionFactory.getCurrentSession();
	}

	@Override
	public List<User> getAllCustomers() {
		return session
						.createQuery("from customers order by lastName", User.class)
						.getResultList();
	}
}
