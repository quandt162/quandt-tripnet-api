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

import com.tripnet.enties.JoinGroup;
import com.tripnet.services.ICommonService;
import com.tripnet.services.IJoinGroupService;
/*
 * *Author: QuanDT
 */
@Controller
@RequestMapping("tours/post")
public class JoinGroupController {
	@Autowired
	private ICommonService<JoinGroup> commonService;
	@Autowired
	private IJoinGroupService<JoinGroup> JoinGroupService;
	
	@GetMapping("{postid}/joingroup/{cid}")
	public ResponseEntity<JoinGroup> getJoinGroupById(@PathVariable("postid") Integer postid,@PathVariable("cid") Integer cid) {
		JoinGroup JoinGroup = commonService.getOneById(cid);
		return new ResponseEntity<JoinGroup>(JoinGroup, HttpStatus.OK);
	}
	
	@GetMapping("/joingroup/get-all")
	public ResponseEntity<List<JoinGroup>> getAll() {
		List<JoinGroup> list = JoinGroupService.getAll();
		return new ResponseEntity<List<JoinGroup>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/joingroup/get-all-by-tourpost/{postid}")
	public ResponseEntity<List<JoinGroup>> getAllJoinGroups(@PathVariable("postid") Integer postid) {
		List<JoinGroup> list = JoinGroupService.getAllJoinGroupByTourPostID(postid);
		return new ResponseEntity<List<JoinGroup>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("/joingroup")
	public ResponseEntity<Void> addJoinGroup(@RequestBody JoinGroup JoinGroup, UriComponentsBuilder builder) {
        boolean flagJoinGroup = commonService.add(JoinGroup);
        if (flagJoinGroup == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(JoinGroup.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@PutMapping("/joingroup")
	public ResponseEntity<JoinGroup> updateJoinGroup(@RequestBody JoinGroup JoinGroup) {
		commonService.update(JoinGroup);
		return new ResponseEntity<JoinGroup>(JoinGroup, HttpStatus.OK);
	}
	
	public JoinGroupController() {
		// TODO Auto-generated constructor stub
	}
}
