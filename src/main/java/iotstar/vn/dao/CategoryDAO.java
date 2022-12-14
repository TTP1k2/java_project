package iotstar.vn.dao;

import java.util.List;
import iotstar.vn.model.Category;

public interface CategoryDAO {
	void insert(Category category);
	void edit(Category category);
	void delete(int id);
	Category get(int id);
	Category get(String name);
	List<Category> getAll();
	List<Category> search(String keyword);
}
