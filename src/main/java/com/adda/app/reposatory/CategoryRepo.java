package com.adda.app.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adda.app.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
