package com.mealdash.repositories;

import com.mealdash.entities.Cart;
import com.mealdash.entities.MenuItem;
import com.mealdash.entities.User;
import com.mealdash.interfaces.dao.CartDAO;
import com.mealdash.interfaces.services.CustomMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {
	private final SessionFactory sessionFactory;
	private final CustomMapper customMapper;

	@Autowired
	public CartDAOImpl(SessionFactory sessionFactory, CustomMapper customMapper) {
		this.sessionFactory = sessionFactory;
		this.customMapper = customMapper;
	}

	@Override
	public Cart createNewCart(int userId) {
		var session = sessionFactory.getCurrentSession();
		var user = session.get(User.class, userId);
		var cart = new Cart();
		cart.setUser(user);
		session.save(cart);
		var id = cart.getId();
		user.setCart(cart);
		return cart;
	}

	@Override
	public void addItemToCart(int cartId, int itemId) {
		var session = sessionFactory.getCurrentSession();
		var cart = session.get(Cart.class, cartId);
		var item = session.get(MenuItem.class, itemId);
		var cartItem = customMapper.mapItemToCartItem(item);
		// TODO
		cartItem.setQuantity(0);
		cart.addItemToCartItems(cartItem);
	}
}
