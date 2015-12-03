package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import webstore.model.Product;
import webstore.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("/products")
	public String list(Model model) {

		Product iphone = productService.getProductById("P1234");
		model.addAttribute("product", iphone);

		return "products";

	}

}
