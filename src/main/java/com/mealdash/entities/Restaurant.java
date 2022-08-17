package com.mealdash.entities;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private int id;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_id")
	private Menu menu;

	public Restaurant() {
	}

	public Restaurant(Menu menu) {
		this.menu = menu;
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
}
