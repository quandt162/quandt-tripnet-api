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

import com.tripnet.enties.TourByDay;
import com.tripnet.services.ICommonService;
import com.tripnet.services.ITourByDayService;
/*
 * *Author: QuanDT
 */
@Controller
@RequestMapping("tours/post")
public class TourByDayController {
	@Autowired
	private ICommonService<TourByDay> commonService;
	@Autowired
	private ITourByDayService<TourByDay> tourByDayService;
	
	@GetMapping("{postID}/day/{day}")
	public ResponseEntity<TourByDay> getTourByDayById(@PathVariable("postID") Integer postID,@PathVariable("day") Integer day) {
		TourByDay t  = tourByDayService.getTourByDayByTourPost(postID, day);
		return new ResponseEntity<TourByDay>(t, HttpStatus.OK);
	}
	
	@GetMapping("{postID}/get-all")
	public ResponseEntity<List<TourByDay>> getAllTourByDays(@PathVariable("postID") Integer postID) {
		List<TourByDay> list = tourByDayService.getAllTourByDayByTourPost(postID);
		return new ResponseEntity<List<TourByDay>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("{id}/day")
	public ResponseEntity<Void> addTourByDay(@RequestBody TourByDay TourByDay, UriComponentsBuilder builder,@PathVariable("id") Integer id) {
        boolean flag = commonService.add(TourByDay);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(TourByDay.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}/day")
	public ResponseEntity<TourByDay> updateTourByDay(@RequestBody TourByDay TourByDay,@PathVariable("id") Integer id) {
		commonService.update(TourByDay);
		return new ResponseEntity<TourByDay>(TourByDay, HttpStatus.OK);
	}
}
