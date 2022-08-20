package com.mealdash.controllers;

import com.mealdash.interfaces.dao.MenuDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class MenuController {
	private final MenuDAO menuDAO;

	public MenuController(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	@GetMapping("/get")
	public String getMenuItems(@RequestParam("menuId") int menuId, Model model) {
		var menu = menuDAO.getMenuById(menuId);
		model.addAttribute("items", menu.getMenuItems());
		return "menu/list";
	}
}
