package com.adda.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adda.app.Entity.Rating;
import com.adda.app.Entity.Review;
import com.adda.app.Service.ReviewService;
import com.adda.app.reposatory.ReviewRepo;
@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepo repo;
	@Override
	public Review SaveReview(Review review) {
		// TODO Auto-generated method stub
		return this.repo.save(review);
	}

	@Override
	public List<Review> getReviewBySpecificMaid(Long id) {
		// TODO Auto-generated method stub
		return this.repo.getReviewOfSpecificMaid(id);
	}

}
