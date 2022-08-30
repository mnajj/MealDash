package com.mealdash.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/get")
	public String get() {
		return "/test/get";
	}

	@PostMapping("/form")
	public String postForm() {
		return "/test/get";
	}
}
