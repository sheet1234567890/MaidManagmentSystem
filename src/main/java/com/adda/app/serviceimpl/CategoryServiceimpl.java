package com.adda.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adda.app.Entity.Category;
import com.adda.app.Service.CategorySerice;
import com.adda.app.reposatory.CategoryRepo;

@Service
public class CategoryServiceimpl implements CategorySerice{
  @Autowired
	private CategoryRepo crepo;
	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return this.crepo.save(category);
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return this.crepo.findAll();
	}

	@Override
	public void DeleteCategory(Long id) {
		// TODO Auto-generated method stub
		Category c = crepo.findById(id).orElse(null);
		this.crepo.delete(c);
		
	}

	@Override
	public Category updateCategory(Long id) {
		// TODO Auto-generated method stub
		Category c = this.crepo.findById(id).orElse(null);
		
		return null;
	}

}
