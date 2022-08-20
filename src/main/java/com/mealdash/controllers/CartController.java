package com.mealdash.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

	@GetMapping("/addItem")
	public String addItemToCart(@RequestParam("itemId") int itemId, @RequestParam("menuId") int menuId) {
		// get user by id
		// get user cart
		// add item to cart
		return "redirect:/menu/get?menuId=" + menuId;
	}
}
