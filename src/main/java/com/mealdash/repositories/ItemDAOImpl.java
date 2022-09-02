package com.mealdash.repositories;

import com.mealdash.entities.MenuItem;
import com.mealdash.interfaces.dao.ItemDAO;
import com.mealdash.interfaces.services.CustomMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ItemDAOImpl implements ItemDAO {
	private final SessionFactory sessionFactory;

	@Autowired
	public ItemDAOImpl(SessionFactory sessionFactory, CustomMapper customMapper) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public MenuItem getItemById(int id) {
		var session = sessionFactory.getCurrentSession();
		return session.get(MenuItem.class, id);
	}
}
