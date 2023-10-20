package com.adda.app.Service;

import java.util.List;

import com.adda.app.Entity.Rating;
import com.adda.app.Entity.Review;

public interface ReviewService {

	public Review SaveReview(Review review);
	public List<Rating> getReviewBySpecificMaid(Long id);
}
