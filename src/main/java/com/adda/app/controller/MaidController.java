package com.adda.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adda.app.Entity.Maid;
import com.adda.app.Service.maidService;

@RestController
@RequestMapping("/admin/maid")
@CrossOrigin
public class MaidController {
    @Autowired
	private maidService service;
	@PostMapping("/save")
	public ResponseEntity<Maid>saveMaid(@RequestBody Maid maid)
	{
		return new ResponseEntity<Maid>(this.service.SaveMaid(maid),HttpStatus.CREATED);
	}
	@GetMapping("/get")
	public ResponseEntity<List<Maid>>getAllMaid()
	{
		return new ResponseEntity<List<Maid>>(this.service.listofMaids(),HttpStatus.OK);
	}
	@GetMapping("/active")
	public ResponseEntity<List<Maid>>getActiveMaids()
	{
		return new ResponseEntity<List<Maid>>(this.service.listOfActiveMaids(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<List<Maid>> getMaidOfCategoryWise(@PathVariable Long id)
	{
		return new ResponseEntity<List<Maid>>(this.service.listOfCategoryWiseMaids(id),HttpStatus.OK);
	}
	
}
