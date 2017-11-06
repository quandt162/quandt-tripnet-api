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

import com.tripnet.enties.Comment;
import com.tripnet.services.ICommonService;
/*
 * *Author: QuanDT
 */
@Controller
@RequestMapping("tours/post")
public class CommentController {
	@Autowired
	private ICommonService<Comment> commonService;
	
	@GetMapping("{postid}/comment/cid")
	public ResponseEntity<Comment> getCommentById(@PathVariable("postid") Integer postid,@PathVariable("cid") Integer cid) {
		Comment Comment = commonService.getOneById(cid);
		return new ResponseEntity<Comment>(Comment, HttpStatus.OK);
	}
	
	@GetMapping("{postid}/comment/get_all")
	public ResponseEntity<List<Comment>> getAllComments() {
		List<Comment> list = commonService.getAll();
		return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("{postid}/comment")
	public ResponseEntity<Void> addComment(@RequestBody Comment Comment, UriComponentsBuilder builder,@PathVariable("postid") Integer postid) {
        boolean flagComment = commonService.add(Comment);
        if (flagComment == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(Comment.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@PutMapping("{postid}/comment")
	public ResponseEntity<Comment> updateComment(@RequestBody Comment Comment,@PathVariable("postid") Integer postid) {
		commonService.update(Comment);
		return new ResponseEntity<Comment>(Comment, HttpStatus.OK);
	}
	
	public CommentController() {
		// TODO Auto-generated constructor stub
	}
}
