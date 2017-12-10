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

import com.tripnet.enties.ReportTourPost;
import com.tripnet.enties.TourPost;
import com.tripnet.services.ICommonService;
import com.tripnet.services.IReportTourPostService;

/*
 * *Author: QuanDT
 */
@Controller
@RequestMapping("tours/post")
public class ReportTourPostController {
	@Autowired
	private ICommonService<ReportTourPost> common;
	@Autowired
	private IReportTourPostService<ReportTourPost> reportTourPostService;
	
	//get report by report id
	@GetMapping("report-tour/{rid}")
	public ResponseEntity<ReportTourPost> getReportTourPostById(@PathVariable("rid") Integer rid) {
		ReportTourPost ReportTourPost = common.getOneById(rid);
		return new ResponseEntity<ReportTourPost>(ReportTourPost, HttpStatus.OK);
	}
	
	//get all post report by account id
	@GetMapping("get-all-report-by-account/{reportedBy}")
	public ResponseEntity<List<ReportTourPost>> getAllReportTourPosts(@PathVariable("reportedBy") Integer reportedBy) {
		List<ReportTourPost> list = reportTourPostService.getAllReportByAccountID(reportedBy);
		return new ResponseEntity<List<ReportTourPost>>(list, HttpStatus.OK);
	}
	
	//get all report of a post
	@GetMapping("get-all-report-of-post/{postID}")
	public ResponseEntity<List<ReportTourPost>> getAllReportOfPost(@PathVariable("postID") Integer postID) {
		List<ReportTourPost> list = reportTourPostService.getAllReportOfPost(postID);
		return new ResponseEntity<List<ReportTourPost>>(list, HttpStatus.OK);
	}
	//get number report of a post
	@GetMapping("get-number-report-of-post/{postID}")
	public ResponseEntity<Integer> getNumberReportOfPost(@PathVariable("postID") Integer postID) {
		int numberReport = reportTourPostService.getNumberReportOfPost(postID);
        return new ResponseEntity<Integer>(numberReport, HttpStatus.CREATED);
	}
	
	@PostMapping("/report-tour")
	public ResponseEntity<Void> addReportTourPost(@RequestBody ReportTourPost ReportTourPost, UriComponentsBuilder builder) {
        boolean flagReportTourPost = common.add(ReportTourPost);
        if (flagReportTourPost == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(ReportTourPost.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@PutMapping("/report-tour")
	public ResponseEntity<ReportTourPost> updateReportTourPost(@RequestBody ReportTourPost ReportTourPost) {
		common.update(ReportTourPost);
		return new ResponseEntity<ReportTourPost>(ReportTourPost, HttpStatus.OK);
	}
	
	public ReportTourPostController() {
		// TODO Auto-generated constructor stub
	}
}
