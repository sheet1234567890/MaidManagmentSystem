
package com.adda.app.Service;

import java.util.List;

import com.adda.app.Entity.Rating;

public interface RatingService {

	
	public Rating saveRating(Rating rating);
	public List<Rating> getRatingSpecificmaid(Long id);
}
