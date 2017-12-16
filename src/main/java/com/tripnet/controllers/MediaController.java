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

import com.tripnet.enties.Media;
import com.tripnet.enties.Media;
import com.tripnet.services.ICommonService;
import com.tripnet.services.IMediaService;
import com.tripnet.services.IMediaService;
/*
 * *Author: QuanDT
 */
@Controller
@RequestMapping("tours/post")
public class MediaController {
	@Autowired
	private ICommonService<Media> commonService;
	@Autowired
	private IMediaService<Media> MediaService;
	
//	@GetMapping("{media}/{mid}")
//	public ResponseEntity<Media> getMediaById(@PathVariable("mid") Integer mid) {
//		Media Media = commonService.getOneById(mid);
//		return new ResponseEntity<Media>(Media, HttpStatus.OK);
//	}
//	
	@GetMapping("/media/get-by-account/{accountID}")
	public ResponseEntity<List<Media>> getImageByAccount(@PathVariable("accountID") Integer accountID) {
		List<Media> list = MediaService.getAllMediaByAccountID(accountID);
		return new ResponseEntity<List<Media>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/media/get-by-tourbyday/{tourByDayID}")
	public ResponseEntity<List<Media>> getAllMediaByTourByDayID(@PathVariable("tourByDayID") Integer tourByDayID) {
		List<Media> list = MediaService.getAllMediaByTourByDayID(tourByDayID);
		return new ResponseEntity<List<Media>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/media/get-by-tourpost/{tourPostID}")
	public ResponseEntity<List<Media>> getAllMediaByTourPostID(@PathVariable("tourPostID") Integer tourPostID) {
		List<Media> list = MediaService.getAllMediaByTourPostID(tourPostID);
		return new ResponseEntity<List<Media>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/media")
	public ResponseEntity<Void> addMedia(@RequestBody Media Media, UriComponentsBuilder builder) {
        boolean flagMedia = commonService.add(Media);
        if (flagMedia == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(Media.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@PutMapping("/media")
	public ResponseEntity<Media> updateMedia(@RequestBody Media Media) {
		commonService.update(Media);
		return new ResponseEntity<Media>(Media, HttpStatus.OK);
	}
	
	public MediaController() {
		// TODO Auto-generated constructor stub
	}
}
