package com.adda.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adda.app.Entity.Category;
import com.adda.app.Service.CategorySerice;

@CrossOrigin
@RequestMapping("/admin/cat")
@RestController
public class CategoryController {
    @Autowired
	private CategorySerice service;
    @PostMapping("/save")
   public ResponseEntity<Category> saveCategory(@RequestBody Category category)
  {
	return new ResponseEntity<Category>(this.service.saveCategory(category),HttpStatus.CREATED);
  }	
    @GetMapping
    public ResponseEntity<List<Category>> getall()
    {
    	return new ResponseEntity<List<Category>>(this.service.getAll(),HttpStatus.OK);
    }
    @DeleteMapping("/del/{id}")
	public void deletecategory(@PathVariable Long id) 
	{
		this.service.DeleteCategory(id);
	}
    @PutMapping("update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id)
    {
    	return new ResponseEntity<Category>(this.service.updateCategory(id),HttpStatus.OK);
    }
}
