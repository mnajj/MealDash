package com.mealdash.viewsModels;

public class MenuItemsListModel {
	private int id;
	private String name;
	private int quantity;
	private String unitPrice;
	private String size;
	private String imagePath;
	private int menuId;

	public MenuItemsListModel(int id, String name, int quantity, String unitPrice, String size, String imagePath, int menuId) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.size = size;
		this.imagePath = imagePath;
		this.menuId = menuId;
	}

	public MenuItemsListModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
}
