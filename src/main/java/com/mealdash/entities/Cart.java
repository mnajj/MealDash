package com.mealdash.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int id;
	@Column(name = "username")
	private String username;


	@OneToOne
	@JoinColumn(name = "username", insertable = false, updatable = false)
	private User user;

	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	private List<CartItem> cartItems;

	public Cart(User user, List<CartItem> cartItems) {
		this.user = user;
		this.cartItems = cartItems;
	}

	public Cart() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addItemToCartItems(CartItem item) {
		if (cartItems == null) {
			cartItems = new ArrayList<>();
		}
		cartItems.add(item);
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
