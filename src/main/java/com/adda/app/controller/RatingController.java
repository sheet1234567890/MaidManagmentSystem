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

import com.adda.app.Entity.Rating;
import com.adda.app.Service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
	private RatingService service;
    @PostMapping("/save")
	public ResponseEntity<Rating>saveRating(@RequestBody Rating rating){
    	System.out.println("dfgdf");
		return new ResponseEntity<Rating>(this.service.saveRating(rating),HttpStatus.CREATED);
				
	}
    @GetMapping("/{mid}")
    public ResponseEntity<List<Rating>>getRatingByMaidId(@PathVariable Long mid)
    {
    	return new ResponseEntity<List<Rating>>(this.service.getRatingSpecificmaid(mid),HttpStatus.OK);
    }
}
