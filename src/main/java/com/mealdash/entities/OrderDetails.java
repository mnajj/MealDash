package com.mealdash.entities;

import com.mealdash.entities.keys.OrderDetailsId;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {
	@EmbeddedId
	private OrderDetailsId orderDetailsId;
	@ManyToOne(fetch = FetchType.LAZY,
					cascade = {CascadeType.DETACH, CascadeType.MERGE,
									CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(referencedColumnName = "order_id")
	private Order order;
	@OneToOne(fetch = FetchType.LAZY,
					cascade = {CascadeType.DETACH, CascadeType.MERGE,
									CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(referencedColumnName = "menu_item_id")
	private MenuItem menuItem;
	@Column(name = "quantity")
	private int quantity;

	public OrderDetails(OrderDetailsId orderDetailsId, Order order, MenuItem menuItem, int quantity) {
		this.orderDetailsId = orderDetailsId;
		this.order = order;
		this.menuItem = menuItem;
		this.quantity = quantity;
	}

	public OrderDetails() {
	}

	public OrderDetailsId getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(OrderDetailsId orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
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
