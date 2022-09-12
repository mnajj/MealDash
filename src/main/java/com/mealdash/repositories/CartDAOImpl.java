package com.mealdash.repositories;

import com.mealdash.entities.*;
import com.mealdash.interfaces.dao.CartDAO;
import com.mealdash.interfaces.services.CustomMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;

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
	public void updateCartItemQuantity(CartItem cartItem) {
		var session = sessionFactory.getCurrentSession();
		var item = session
						.createQuery("from CartItem c where c.id=:id and c.cart.id=:cid", CartItem.class)
						.setParameter("id", cartItem.getId())
						.setParameter("cid", cartItem.getCart().getId())
						.getSingleResult();
		item.setQuantity(cartItem.getQuantity());
		session.save(item);
	}

	@Override
	public void checkOut(String userName, int cartId) {
		var session = sessionFactory.getCurrentSession();
		var user = session
						.createQuery("from User u where u.userName=:usnm", User.class)
						.setParameter("usnm", userName)
						.getSingleResult();
		var cart = user.getCart();

		if (cart.getCartItems().isEmpty()) return;
		var order = new Order();
		order.setDate(new Date());
		order.setUser(user);
		session.save(order);
		var id = order.getId();

		var cartItemQty = new HashMap<Integer, Integer>();

		for (var c : cart.getCartItems()) {
			cartItemQty.put(c.getMenuItemId(), c.getQuantity());
			var orderItem = new OrderDetails();
			orderItem.setMenuItem(c.getMenuItem());
			orderItem.setOrder(order);
			orderItem.setQuantity(c.getQuantity());
			orderItem.setOrderId(order.getId());
			orderItem.setMenuItemId(c.getMenuItemId());
			session.save(orderItem);
			session.delete(c);
		}
		var menuItems = session
						.createQuery("from MenuItem", MenuItem.class)
						.getResultList();
		for (var item : menuItems) {
			if (cartItemQty.containsKey(item.getId())) {
				item.setQuantity(item.getQuantity() - cartItemQty.get(item.getId()));
				session.save(item);
			}
		}
	}
}