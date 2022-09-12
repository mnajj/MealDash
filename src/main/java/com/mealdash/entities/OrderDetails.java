package com.mealdash.entities;

import com.mealdash.entities.keys.OrderDetailsPK;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@IdClass(OrderDetailsPK.class)
public class OrderDetails {
	//	@Id
//	@Column(name = "order_details_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int orderDetailsId;
	@Id
	@Column(name = "order_id")
	private int orderId;
	@Id
	@Column(name = "menu_item_id")
	private int menuItemId;
	@ManyToOne(fetch = FetchType.LAZY,
					cascade = {CascadeType.DETACH, CascadeType.MERGE,
									CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;
	@OneToOne(fetch = FetchType.LAZY,
					cascade = {CascadeType.DETACH, CascadeType.MERGE,
									CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "menu_item_id", insertable = false, updatable = false)
	private MenuItem menuItem;
	@Column(name = "quantity")
	private int quantity;

	public OrderDetails(int orderId, int menuItemId, Order order, MenuItem menuItem, int quantity) {
		this.orderId = orderId;
		this.menuItemId = menuItemId;
		this.order = order;
		this.menuItem = menuItem;
		this.quantity = quantity;
	}

	public OrderDetails() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
