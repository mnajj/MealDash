package com.mealdash.entities.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailsId implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_details_id")
	private int id;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "menu_item_id")
	private int menuItemId;

	public OrderDetailsId() {
	}

	public OrderDetailsId(int orderId, int menuItemId) {
		this.orderId = orderId;
		this.menuItemId = menuItemId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderDetailsId)) return false;
		OrderDetailsId that = (OrderDetailsId) o;
		return Objects.equals(getId(), that.getId()) &&
						Objects.equals(getOrderId(), that.getOrderId()) &&
						Objects.equals(getMenuItemId(), that.getMenuItemId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getOrderId(), getMenuItemId());
	}

	public int getId() {
		return id;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getMenuItemId() {
		return menuItemId;
	}

}
