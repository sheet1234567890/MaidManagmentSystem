package com.adda.app.reposatory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adda.app.Entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {
  @Query("SELECT r From Review r WHERE r.maid.mId=:id")
	List<Review> getReviewOfSpecificMaid(Long id);

}
