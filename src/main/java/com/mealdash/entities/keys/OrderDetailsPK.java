package com.mealdash.entities.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailsPK implements Serializable {
	//	private int orderDetailsId;
	private int orderId;
	private int menuItemId;

	public OrderDetailsPK(int orderId, int menuItemId) {
		this.orderId = orderId;
		this.menuItemId = menuItemId;
	}

	public OrderDetailsPK() {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderDetailsPK)) return false;
		OrderDetailsPK that = (OrderDetailsPK) o;
		return Objects.equals(getOrderId(), that.getOrderId()) &&
						Objects.equals(getMenuItemId(), that.getMenuItemId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getOrderId(), getMenuItemId());
	}
}
