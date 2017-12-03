package com.tripnet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.tripnet.enties.Place;
import com.tripnet.services.ICommonService;
/*
 * *Author: QuanDT
 */
@Controller
@RequestMapping("place")
public class PlaceController {
	@Autowired
	private ICommonService<Place> commonService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Place> getPlaceById(@PathVariable("id") Integer id) {
		Place Place = commonService.getOneById(id);
		return new ResponseEntity<Place>(Place, HttpStatus.OK);
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<List<Place>> getAllPlaces() {
		List<Place> list = commonService.getAll();
		return new ResponseEntity<List<Place>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("place")
	public ResponseEntity<Void> addPlace(@RequestBody Place Place, UriComponentsBuilder builder) {
        boolean flagPlace = commonService.add(Place);
        if (flagPlace == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(Place.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@PutMapping("place")
	public ResponseEntity<Place> updatePlace(@RequestBody Place Place) {
		commonService.update(Place);
		return new ResponseEntity<Place>(Place, HttpStatus.OK);
	}
	
	public PlaceController() {
		// TODO Auto-generated constructor stub
	}

}
