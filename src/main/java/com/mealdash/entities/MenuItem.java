package com.mealdash.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu_item")
public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_item_id")
	private int id;

	@Column(name = "name")
	private String name;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	@Column(name = "size")
	private String size;

	@Column(name = "image_path")
	private String imagePath;

	@ManyToOne(fetch = FetchType.LAZY,
					cascade = {CascadeType.DETACH, CascadeType.MERGE,
									CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "menu_id")
	private Menu menu;

	public MenuItem(String name, int quantity, BigDecimal unitPrice, String size, String imagePath, Menu menu) {
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.size = size;
		this.imagePath = imagePath;
		this.menu = menu;
	}

	public MenuItem() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
