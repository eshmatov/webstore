package webstore.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import webstore.model.Product;

@Repository
public class ProductDaoImpl implements ProductDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Product entity) {
		Session session = sessionFactory.getCurrentSession();
		entity.setProductId((String) session.save(entity));
	}

	@SuppressWarnings("unchecked")
	public List<Product> getList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Product").list();
	}

	public void update(Product entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	public Product getProductById(String productID) {
		Session session = sessionFactory.getCurrentSession();
		return (Product) session.get(Product.class, productID);
	}

	public void deleteProduct(String productId) {
		Session session = sessionFactory.getCurrentSession();
		Product p = (Product) session.get(Product.class, productId);
		if (p != null) {
			session.delete(p);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> listByCategory(String categoryName) {
		Session session = sessionFactory.getCurrentSession();

		Criteria c = session.createCriteria(Product.class);
		c.add(Restrictions.like("category", categoryName, MatchMode.ANYWHERE));

		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {

		Session session = sessionFactory.getCurrentSession();

		Criteria c = session.createCriteria(Product.class);
		Set<Entry<String, List<String>>> params = filterParams.entrySet();
		for (Entry<String, List<String>> e : params) {
			c.add(Restrictions.in(e.getKey().toLowerCase().trim(), e.getValue()));
		}
		return c.list();
	}

}
