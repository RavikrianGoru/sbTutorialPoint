package com.rk.springboot.consumeRws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/view")
	public String viewProducts()
	{
		return "view-products";
	}
	
	@RequestMapping("/add")
	public String addProduct()
	{
		return "add-product";
	}
}
