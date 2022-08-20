package com.mealdash.repositories;

import com.mealdash.entities.Restaurant;
import com.mealdash.interfaces.dao.RestaurantDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RestaurantDAOImpl implements RestaurantDAO {


	private final SessionFactory sessionFactory;

	@Autowired
	public RestaurantDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Restaurant> getAllRestaurants() {
		var session = sessionFactory.getCurrentSession();
		return session
						.createQuery("from Restaurant", Restaurant.class)
						.getResultList();
	}
}
