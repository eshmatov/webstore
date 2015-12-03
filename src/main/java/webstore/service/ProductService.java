package webstore.service;

import java.util.List;
import java.util.Map;

import webstore.model.Product;

public interface ProductService {

	public void create(Product product);

	public List<Product> getList();

	public void update(Product product);

	public Product getProductById(String productID);

	public void deleteProduct(String productId);

	public List<Product> listByCategory(String categoryName);

	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

}
