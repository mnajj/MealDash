package com.mealdash.interfaces.dao;

import com.mealdash.entities.Cart;
import com.mealdash.entities.CartItem;

public interface CartDAO {
	Cart createNewCart(String userName);

	void addItemToCart(int cartId, int itemId, int quantity);

	Cart getUserCart(String userName);

	void deleteCartItem(int cartId, int itemId);

	CartItem getCartItemById(int itemId);

	void updateCartItemQuantity(int itemId, int quantity);
}
