package webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getList());

		return "products";
	}

	@RequestMapping("/all")
	public String productsAll(Model model) {
		model.addAttribute("products", productService.getList());

		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(@PathVariable String category, Model model) {
		model.addAttribute("products", productService.listByCategory(category));

		return "products";
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByCriteria(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));

		return "products";
	}

	@RequestMapping("/product")
	public String getProduct(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

}
