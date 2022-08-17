package com.mealdash.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;

	@Column(name = "date")
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY,
					cascade = {CascadeType.DETACH, CascadeType.MERGE,
									CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<OrderDetails> orderDetails;
}
