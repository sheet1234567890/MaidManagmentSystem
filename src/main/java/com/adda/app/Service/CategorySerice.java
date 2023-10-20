package com.adda.app.Service;

import java.util.List;

import com.adda.app.Entity.Category;

public interface CategorySerice {

	public Category saveCategory(Category category);
	public List<Category> getAll();
	public void DeleteCategory(Long id);
	public Category updateCategory(Long id);
	
	
}
