package com.mealdash.repositories;

import com.mealdash.entities.User;
import com.mealdash.interfaces.dao.UserDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
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
						.createQuery("from User order by lastName", User.class)
						.getResultList();
	}

	@Override
	public User getUserById(int id) {
		var session = sessionFactory.getCurrentSession();
		var user = session.get(User.class, id);
		var cart = user.getCart();
		return user;
	}

}
