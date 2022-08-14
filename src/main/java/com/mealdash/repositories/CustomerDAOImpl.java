package com.mealdash.repositories;

import com.mealdash.entities.Customer;
import com.mealdash.interfaces.dao.CustomerDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private final Session session;

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.session = sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		return session
						.createQuery("from customers", Customer.class)
						.getResultList();
	}
}
