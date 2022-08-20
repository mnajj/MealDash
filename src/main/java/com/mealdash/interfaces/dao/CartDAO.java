package com.mealdash.interfaces.dao;

import com.mealdash.entities.Cart;

public interface CartDAO {
	Cart createNewCart(int userId);

	void addItemToCart(int cartId, int itemId);
}
