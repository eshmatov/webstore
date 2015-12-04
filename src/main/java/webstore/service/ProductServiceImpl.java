package webstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstore.dao.ProductDAO;
import webstore.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;

	@Transactional
	public void create(Product product) {
		productDao.create(product);
	}

	@Transactional
	public List<Product> getList() {
		return productDao.getList();
	}

	@Transactional
	public void update(Product product) {
		productDao.update(product);
	}

	@Transactional
	public Product getProductById(String productID) {
		return productDao.getProductById(productID);
	}

	@Transactional
	public void deleteProduct(String productId) {
		productDao.deleteProduct(productId);
	}

	@Transactional
	public List<Product> listByCategory(String categoryName) {
		return productDao.listByCategory(categoryName);
	}

	@Transactional
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productDao.getProductsByFilter(filterParams);
	}

	@Transactional
	public void addProduct(Product product) {
		productDao.create(product);
	}

}
