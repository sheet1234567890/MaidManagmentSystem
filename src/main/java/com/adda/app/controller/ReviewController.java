package com.adda.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adda.app.Entity.Review;
import com.adda.app.Service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
   @Autowired
	private ReviewService Service;
	@PostMapping("/save")
	public ResponseEntity<Review> saveReview(@RequestBody Review review)
	{
		return new ResponseEntity<Review>(this.Service.SaveReview(review),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<List<Review>> getReviewOfSpecificMai(@PathVariable Long id)
	{
		return new ResponseEntity<List<Review>>(this.Service.getReviewBySpecificMaid(id),HttpStatus.OK);
	}
}
