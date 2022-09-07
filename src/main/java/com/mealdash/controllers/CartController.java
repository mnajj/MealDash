package com.mealdash.controllers;

import com.mealdash.entities.CartItem;
import com.mealdash.entities.MenuItem;
import com.mealdash.interfaces.dao.CartDAO;
import com.mealdash.interfaces.dao.ItemDAO;
import com.mealdash.interfaces.dao.UserDAO;
import com.mealdash.interfaces.services.CustomMapper;
import com.mealdash.viewsModels.MenuItemsListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/cart")
public class CartController {
	private final UserDAO userDAO;
	private final CartDAO cartDAO;
	private final ItemDAO itemDAO;
	private final CustomMapper customMapper;

	@Autowired
	public CartController(UserDAO userDAO, CartDAO cartDAO, ItemDAO itemDAO, CustomMapper customMapper) {
		this.userDAO = userDAO;
		this.cartDAO = cartDAO;
		this.itemDAO = itemDAO;
		this.customMapper = customMapper;
	}

	@GetMapping("/get-user-cart")
	public String getUserCartItems(Authentication auth, Model model) {
		var cart = cartDAO.getUserCart(auth.getName());
		model.addAttribute("cart", cart);
		return "cart/cart-items";
	}

	@PostMapping("/add-item")
	public String addItemToCart(
					Authentication auth,
					@RequestParam("itemId") int itemId,
					@RequestParam("menuId") int menuId, @ModelAttribute("item") MenuItemsListModel item) {
		if (item.getQuantityInput() > item.getQuantity() || item.getQuantityInput() <= 0) {
			return "redirect:/cart/def-itm-qty"
							+ "?itemId=" + itemId
							+ "&menuId=" + menuId
							+ "&invalid=1";
		}
		var user = userDAO.getUserByUserName(auth.getName());
		var cart = user.getCart();
		if (cart == null) {
			cart = cartDAO.createNewCart(auth.getName());
		}
		cartDAO.addItemToCart(cart.getId(), itemId, item.getQuantityInput());
		return "redirect:/menu/get?menuId=" + menuId;
	}

	@GetMapping("/def-itm-qty")
	public String getItemQuantityPage(
					@RequestParam("itemId") int itemId, @RequestParam("menuId") int menuId,
					Model model) {
		var menuItems = new ArrayList<MenuItem>();
		var item = itemDAO.getItemById(itemId);
		menuItems.add(item);
		var modelItems = customMapper.mapMenuItems(
						menuItems, menuId);
		model.addAttribute("item", modelItems.get(0));
		return "cart/item-qty";
	}

	@GetMapping("/delete-cart-item")
	public String deleteItemFromCart(@RequestParam("cartId") int cartId, @RequestParam("cartItemId") int cartItemId) {
		cartDAO.deleteCartItem(cartId, cartItemId);
		return "redirect:/cart/get-user-cart";
	}


	@GetMapping("update-item-qty")
	public String redirectToQuantityPage(@RequestParam("itemId") int itemId, Model model) {
		var item = cartDAO.getCartItemById(itemId);
		model.addAttribute("item", item);
		return "cart/cart-item-qty";
	}

	@PostMapping("update-new-qty")
	public String updateItemQuantity(@ModelAttribute("item") CartItem cartItem) {
		cartDAO.updateCartItemQuantity(cartItem.getId(), cartItem.getQuantity());
		return "redirect:/cart/get-user-cart";
	}
}
