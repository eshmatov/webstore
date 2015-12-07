package webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import webstore.dao.ProductDAO;
import webstore.model.Product;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductDAO productDao;

	
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	 
	public void processOrder(String productId, int quantity) {
		Product product = productDao.getProductById(productId);

		if (product.getUnitsInStock() < quantity) {
			throw new IllegalArgumentException("Out of Stock. Available Units in stock" + product.getUnitsInStock());
		}

		product.setUnitsInStock(product.getUnitsInStock() - quantity);
	
		productDao.update(product);
	}

}
