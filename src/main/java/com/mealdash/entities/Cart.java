package com.mealdash.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int id;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "cart")
	private User user;

	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CartItem> cartItems;

	public Cart() {
	}

	public int getId() {
		return id;
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
