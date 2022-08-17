package com.mealdash.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private int id;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "menu")
	private Restaurant restaurants;
	@OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MenuItem> menuItems;

	public Menu(Restaurant restaurants, List<MenuItem> menuItems) {
		this.restaurants = restaurants;
		this.menuItems = menuItems;
	}

	public Menu() {
	}

	public int getId() {
		return id;
	}

	public Restaurant getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Restaurant restaurants) {
		this.restaurants = restaurants;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
