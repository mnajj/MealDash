package com.mealdash.services;

import com.mealdash.entities.CartItem;
import com.mealdash.entities.MenuItem;
import com.mealdash.interfaces.services.CustomMapper;
import com.mealdash.viewsModels.MenuItemsListModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

@Service
public class CustomMapperImpl implements CustomMapper {
	private static String currencyFormat(BigDecimal n) {
		return NumberFormat.getCurrencyInstance().format(n);
	}

	@Override
	public List<MenuItemsListModel> mapMenuItems(List<MenuItem> menuItems, int menuId) {
		return menuItems.stream().
						map(s -> {
							return new MenuItemsListModel(
											s.getId(),
											s.getName(),
											s.getQuantity(),
											currencyFormat(s.getUnitPrice()),
											s.getSize(),
											s.getImagePath(),
											menuId
							);
						}).toList();
	}

	@Override
	public CartItem mapItemToCartItem(MenuItem item) {
		return new CartItem(0, item);
	}
}
