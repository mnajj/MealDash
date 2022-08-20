package com.mealdash.controllers;

import com.mealdash.interfaces.dao.RestaurantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {


	private final RestaurantDAO restaurantDAO;

	@Autowired
	public RestaurantController(RestaurantDAO restaurantDAO) {

		this.restaurantDAO = restaurantDAO;
	}

	@GetMapping("/list")
	public String getRestaurantsList(Model model) {
		var restaurants = restaurantDAO.getAllRestaurants();
		model.addAttribute("restaurants", restaurants);
		return "restaurant/list";
	}
}
