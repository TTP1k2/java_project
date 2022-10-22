package iotstar.vn.service.impl;

import java.io.File;
import java.util.List;
import iotstar.vn.dao.CategoryDAO;
import iotstar.vn.dao.impl.CategoryDAOImpl;
import iotstar.vn.model.Category;
import iotstar.vn.service.CategoryService;

public class CatogeryServiceImpl implements CategoryService {
	CategoryDAO categoryDao = new CategoryDAOImpl();

	@Override
	public void insert(Category category) {
		categoryDao.insert(category);
	}

	@Override
	public void edit(Category newCategory) {
		Category oldCategory = categoryDao.get(newCategory.getCateid());
		oldCategory.setCatename(newCategory.getCatename());
		// XOA ANH CU DI
		if (newCategory.getIcon() != null) {
			String fileName = oldCategory.getIcon();
			final String dir = "E:\\upload";
			File file = new File(dir + "/ category" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setIcon(newCategory.getIcon());
		}
		categoryDao.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
	categoryDao.delete(id);
	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
