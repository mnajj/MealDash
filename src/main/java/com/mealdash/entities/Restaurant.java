package com.mealdash.entities;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private int id;
	@Column(name = "menu_id")
	private Integer menuId;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "menu_id")
	private Menu menu;
	@Column(name = "name")
	private String name;
	@Column(name = "image_path")
	private String imagePath;
	@Column(name = "phone")
	private String phone;
	@Column(name = "address")
	private String address;

	public Restaurant(int menuId, Menu menu, String name, String imagePath, String phone, String address) {
		this.menuId = menuId;
		this.menu = menu;
		this.name = name;
		this.imagePath = imagePath;
		this.phone = phone;
		this.address = address;
	}

	public Restaurant() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
