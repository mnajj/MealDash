package com.mealdash.repositories;

import com.mealdash.entities.Cart;
import com.mealdash.entities.CartItem;
import com.mealdash.entities.MenuItem;
import com.mealdash.entities.User;
import com.mealdash.interfaces.dao.CartDAO;
import com.mealdash.interfaces.services.CustomMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
	public Cart createNewCart(String userName) {
		var session = sessionFactory.getCurrentSession();
		var user = session
						.createQuery("from User where userName = :userName", User.class)
						.setParameter("userName", userName)
						.getSingleResult();
		var cart = new Cart();
		cart.setUser(user);
		session.save(cart);
		var id = cart.getId();
		user.setCart(cart);
		return cart;
	}

	@Override
	public void addItemToCart(int cartId, int itemId, int quantity) {
		var session = sessionFactory.getCurrentSession();
		var cart = session.get(Cart.class, cartId);
		var item = session.get(MenuItem.class, itemId);
		var cartItem = customMapper.mapItemToCartItem(item);
		cartItem.getCart().setId(cartId);
		cartItem.setQuantity(quantity);
		cart.addItemToCartItems(cartItem);
	}

	@Override
	public Cart getUserCart(String userName) {
		var session = sessionFactory.getCurrentSession();
		var cart = session.
						createQuery(
										"SELECT c FROM Cart c LEFT JOIN FETCH c.cartItems where c.username = :userName",
										Cart.class)
						.setParameter("userName", userName)
						.getSingleResult();
		return cart;
	}

	@Override
	@Modifying
	public void deleteCartItem(int cartId, int cartItemId) {
		var session = sessionFactory.getCurrentSession();
		session.
						createQuery(
										"delete FROM CartItem c where id = :cartItemId")
						.setParameter("cartItemId", cartItemId)
						.executeUpdate();
	}

	@Override
	public CartItem getCartItemById(int itemId) {

		var session = sessionFactory.getCurrentSession();
		var cartItem = session
						.createQuery("SELECT i FROM CartItem i LEFT JOIN FETCH i.menuItem where i.id = :id", CartItem.class)
						.setParameter("id", itemId)
						.getSingleResult();
		return cartItem;
	}

	@Override
	public void updateCartItemQuantity(int itemId, int quantity) {
		var session = sessionFactory.getCurrentSession();
		session.
						createQuery("UPDATE CartItem c set c.quantity=:qty where c.id=:id")
						.setParameter("qty", quantity)
						.setParameter("id", itemId)
						.executeUpdate();
	}

}
