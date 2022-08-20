package com.mealdash.interfaces.services;

import com.mealdash.entities.MenuItem;
import com.mealdash.viewsModels.MenuItemsListModel;

import java.util.List;

public interface CustomMapper {
	List<MenuItemsListModel> mapMenuItems(List<MenuItem> menuItems, int menuId);
}
