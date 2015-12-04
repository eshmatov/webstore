package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import webstore.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/{productId}/{quantity}")
	public String process(@PathVariable("productId") String productId, @PathVariable("quantity") int quantity) {
		orderService.processOrder(productId, quantity);

		return "redirect:/products";
	}

}
