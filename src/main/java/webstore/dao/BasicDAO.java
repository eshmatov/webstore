package webstore.dao;

import java.util.List;

public interface BasicDAO<T> {

	public void create(T entity);

	public List<T> getList();

	public void update(T entity);

}
