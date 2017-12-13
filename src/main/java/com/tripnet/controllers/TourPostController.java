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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.tripnet.enties.TourPost;
import com.tripnet.services.ICommonService;
import com.tripnet.services.ITourPostService;
/*
 * *Author: QuanDT
 */
@Controller
@RequestMapping("tours")
public class TourPostController {
	@Autowired
	private ICommonService<TourPost> commonService;
	@Autowired
	private ITourPostService<TourPost> tourPostService;
	
	@GetMapping("post/{id}")
	public ResponseEntity<TourPost> getTourPostById(@PathVariable("id") Integer id) {
		TourPost TourPost = commonService.getOneById(id);
		return new ResponseEntity<TourPost>(TourPost, HttpStatus.OK);
	}
	

	@GetMapping("post/get-all")
	public ResponseEntity<List<TourPost>> getTourPostByDuration() {
		List<TourPost> list = commonService.getAll();
		return new ResponseEntity<List<TourPost>>(list, HttpStatus.OK);
	}
	
	//get post by post title
	@GetMapping("post/title/{title}")
	public ResponseEntity<List<TourPost>> getTourPostByTitle(@PathVariable("title") String title) {
		List<TourPost> list = tourPostService.getAllTourPostByTitle(title);
		return new ResponseEntity<List<TourPost>>(list, HttpStatus.OK);
	}
	//get post by Account Name
	@GetMapping("post/name/{name}")
	public ResponseEntity<List<TourPost>> getTourPostByName(@PathVariable("name") String name) {
		List<TourPost> list = tourPostService.getAllTourPostByAccountName(name);
		return new ResponseEntity<List<TourPost>>(list, HttpStatus.OK);
	}
	
	//get post by duration
	@GetMapping("post/duration/{duration}")
	public ResponseEntity<List<TourPost>> getTourPostByDuration(@PathVariable("duration") int duration) {
		List<TourPost> list = tourPostService.getAllTourPostByDuration(duration);
		return new ResponseEntity<List<TourPost>>(list, HttpStatus.OK);
	}
	
	//get post by Pace
	@GetMapping("post/place/")
	public ResponseEntity<List<TourPost>> getTourPostByDuration(@RequestParam(name="place1",required = false) String place1, 
																@RequestParam(name="place2",required = false) String place2) {
		List<TourPost> list = tourPostService.getAllTourPostByPlace(place1,place2);
		return new ResponseEntity<List<TourPost>>(list, HttpStatus.OK);
	}
	
	//get post by Category name
	@GetMapping("post/category/{name}")
	public ResponseEntity<List<TourPost>> getTourPostByCategory(@PathVariable("name") String name) {
		List<TourPost> list = tourPostService.getAllTourPostByCategory(name);
		return new ResponseEntity<List<TourPost>>(list, HttpStatus.OK);
	}

	
	@PostMapping("post")
	public ResponseEntity<Integer> addTourPost(@RequestBody TourPost TourPost, UriComponentsBuilder builder) {
        boolean flagTourPost = commonService.add(TourPost);
        if (flagTourPost == false) {
        	return new ResponseEntity<Integer>(HttpStatus.CONFLICT);
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(TourPost.getId()).toUri());
        return new ResponseEntity<Integer>(TourPost.getId(), HttpStatus.CREATED);
	}
	
	//anh vao chua a, lam sao de noi chuyen voi a nhi

	@PutMapping("post")
	public ResponseEntity<TourPost> updateTourPost(@RequestBody TourPost TourPost) {
		commonService.update(TourPost);
		return new ResponseEntity<TourPost>(TourPost, HttpStatus.OK);
	}
	
	public TourPostController() {
		// TODO Auto-generated constructor stub
	}

}
