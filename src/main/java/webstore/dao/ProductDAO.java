package webstore.dao;

import java.util.List;
import java.util.Map;

import webstore.model.Product;

public interface ProductDAO extends BasicDAO<Product> {

	public Product getProductById(String productID);

	public void deleteProduct(String productId);

	public List<Product> listByCategory(String categoryName);

	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

}
