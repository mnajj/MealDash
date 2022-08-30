package com.mealdash.controllers;

import com.mealdash.interfaces.dao.CartDAO;
import com.mealdash.interfaces.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {
	private final UserDAO userDAO;
	private final CartDAO cartDAO;

	@Autowired
	public CartController(UserDAO userDAO, CartDAO cartDAO) {
		this.userDAO = userDAO;
		this.cartDAO = cartDAO;
	}

	@GetMapping("/addItem")
	public String addItemToCart(Authentication auth, @RequestParam("itemId") int itemId, @RequestParam("menuId") int menuId) {
		var user = userDAO.getUserByUserName(auth.getName());
		var cart = user.getCart();
		if (cart == null) {
			cart = cartDAO.createNewCart(1);
		}
		cartDAO.addItemToCart(cart.getId(), itemId);
		return "redirect:/menu/get?menuId=" + menuId;
	}
}
