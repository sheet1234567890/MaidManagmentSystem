package com.adda.app.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adda.app.Entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

}
