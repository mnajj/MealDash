package com.mealdash.repositories;

import com.mealdash.entities.Menu;
import com.mealdash.interfaces.dao.MenuDAO;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MenuDAOImpl implements MenuDAO {

	private final SessionFactory sessionFactory;

	public MenuDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Menu getMenuById(int id) {
		var session = sessionFactory.getCurrentSession();
		var menu = session.
						createQuery("SELECT m FROM Menu m LEFT JOIN FETCH m.menuItems", Menu.class)
						.getResultList();
		return menu.get(0);
	}
}
