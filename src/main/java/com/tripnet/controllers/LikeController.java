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

import com.tripnet.enties.Like;
import com.tripnet.services.ICommonService;
import com.tripnet.services.ILikesService;
/*
 * *Author: QuanDT
 */
@Controller
@RequestMapping("tours/post")
public class LikeController {
	@Autowired
	private ICommonService<Like> commonService;
	@Autowired
	private ILikesService<Like> likeService;
	
	@GetMapping("{postid}/like/{cid}")
	public ResponseEntity<Like> getLikeById(@PathVariable("postid") Integer postid,@PathVariable("cid") Integer cid) {
		Like Like = commonService.getOneById(cid);
		return new ResponseEntity<Like>(Like, HttpStatus.OK);
	}
	
	@GetMapping("{postid}/like/get-all")
	public ResponseEntity<List<Like>> getAllLikes(@PathVariable("postid") Integer postid) {
		List<Like> list = likeService.getAllLikeByTourPostID(postid);
		return new ResponseEntity<List<Like>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("/{postid}/Like")
	public ResponseEntity<Void> addLike(@RequestBody Like Like, UriComponentsBuilder builder,@PathVariable("postid") Integer postid) {
        boolean flagLike = commonService.add(Like);
        if (flagLike == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(Like.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@PutMapping("/{postid}/Like")
	public ResponseEntity<Like> updateLike(@RequestBody Like Like,@PathVariable("postid") Integer postid) {
		commonService.update(Like);
		return new ResponseEntity<Like>(Like, HttpStatus.OK);
	}
	
	public LikeController() {
		// TODO Auto-generated constructor stub
	}
}
