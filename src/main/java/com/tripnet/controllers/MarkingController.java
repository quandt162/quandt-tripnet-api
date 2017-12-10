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

import com.tripnet.enties.Marking;
import com.tripnet.services.ICommonService;
import com.tripnet.services.IMarkingService;
/*
 *Author: QuanDT 
 *29/11/2017
 */
@Controller
@RequestMapping("user/account")
public class MarkingController {
	@Autowired
	private ICommonService<Marking> commonService;
	@Autowired
	private IMarkingService<Marking> MarkingService;
	
	@GetMapping("{marking/{mid}")
	public ResponseEntity<Marking> getMarkingById(@PathVariable("mid") Integer mid) {
		Marking Marking = commonService.getOneById(mid);
		return new ResponseEntity<Marking>(Marking, HttpStatus.OK);
	}
	
	@GetMapping("marking/get-all/{accountID}")
	public ResponseEntity<List<Marking>> getAllMarkings(@PathVariable("accountID") Integer accountID) {
		List<Marking> list = MarkingService.getAllMarkingByAccountID(accountID);
		return new ResponseEntity<List<Marking>>(list, HttpStatus.OK);
	}
	
	@GetMapping("marking/get-all-by-tourpost/{tourPostID}")
	public ResponseEntity<List<Marking>> getAllMarkingsByTourPostID(@PathVariable("tourPostID") Integer tourPostID) {
		List<Marking> list = MarkingService.getAllMarkingByTourPostID(tourPostID);
		return new ResponseEntity<List<Marking>>(list, HttpStatus.OK);
	}
	
	@PostMapping("marking")
	public ResponseEntity<Void> addMarking(@RequestBody Marking Marking, UriComponentsBuilder builder) {
        boolean flagMarking = commonService.add(Marking);
        if (flagMarking == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(Marking.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@PutMapping("marking")
	public ResponseEntity<Marking> updateMarking(@RequestBody Marking Marking) {
		commonService.update(Marking);
		return new ResponseEntity<Marking>(Marking, HttpStatus.OK);
	}
	
	public MarkingController() {
		// TODO Auto-generated constructor stub
	}
	
}
