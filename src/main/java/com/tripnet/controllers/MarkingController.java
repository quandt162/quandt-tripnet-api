//package com.tripnet.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.tripnet.enties.Marking;
//import com.tripnet.services.ICommonService;
//import com.tripnet.services.IMarkingService;
//
//public class MarkingController {
//	@Autowired
//	private ICommonService<Marking> commonService;
//	@Autowired
//	private IMarkingService<Marking> Markingervice;
//	
//	@GetMapping("{postid}/like/cid")
//	public ResponseEntity<Marking> getLikeById(@PathVariable("postid") Integer postid,@PathVariable("cid") Integer cid) {
//		Marking Like = commonService.getOneById(cid);
//		return new ResponseEntity<Marking>(Like, HttpStatus.OK);
//	}
//	
//	@GetMapping("{postid}/like/get-all")
//	public ResponseEntity<List<Marking>> getAllMarking(@PathVariable("postid") Integer postid) {
//		List<Marking> list = Markingervice.getAllMarkingByTourPostID(postid);
//		return new ResponseEntity<List<Marking>>(list, HttpStatus.OK);
//	}
//	
//	
//	@PostMapping("{postid}/Like")
//	public ResponseEntity<Void> addLike(@RequestBody Marking Like, UriComponentsBuilder builder,@PathVariable("postid") Integer postid) {
//        boolean flagLike = commonService.add(Like);
//        if (flagLike == false) {
//        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(Like.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}
//	
//
//	@PutMapping("{postid}/Like")
//	public ResponseEntity<Marking> updateLike(@RequestBody Marking Like,@PathVariable("postid") Integer postid) {
//		commonService.update(Like);
//		return new ResponseEntity<Marking>(Like, HttpStatus.OK);
//	}
//	
//}
