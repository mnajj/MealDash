package com.mealdash.controllers;

import com.mealdash.interfaces.dao.MenuDAO;
import com.mealdash.interfaces.services.CustomMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class MenuController {
	private final MenuDAO menuDAO;
	private final CustomMapper customMapper;

	public MenuController(MenuDAO menuDAO, CustomMapper customMapper) {
		this.menuDAO = menuDAO;
		this.customMapper = customMapper;
	}

	@GetMapping("/get")
	public String getMenuItems(@RequestParam("menuId") int menuId, Model model) {
		var menu = menuDAO.getMenuById(menuId);
		var items = customMapper.mapMenuItems(menu.getMenuItems(), menuId);
		model.addAttribute("items", items);
		return "menu/list";
	}

}
