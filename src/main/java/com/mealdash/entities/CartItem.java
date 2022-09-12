package com.mealdash.entities;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_item_id")
	private int id;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@Column(name = "menu_item_id")
	private int menuItemId;
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "menu_item_id", insertable = false, updatable = false)
	private MenuItem menuItem;

	public CartItem(int quantity, MenuItem menuItem) {
		this.quantity = quantity;
		this.menuItem = menuItem;
	}

	public CartItem() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
}
