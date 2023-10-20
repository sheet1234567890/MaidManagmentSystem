package com.adda.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adda.app.Entity.Rating;
import com.adda.app.Service.RatingService;
import com.adda.app.reposatory.RatingRepo;
@Service
public class RatingSericeImpl implements RatingService {

	@Autowired
	private RatingRepo repo;
	@Override
	public Rating saveRating(Rating rating) {
		// TODO Auto-generated method stub
		return this.repo.save(rating);
	}

	@Override
	public List<Rating> getRatingSpecificmaid(Long mid) {
		// TODO Auto-generated method stub
		return this.repo.getRatingByMaidId(mid) ;
	}

}
