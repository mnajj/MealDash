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
}
