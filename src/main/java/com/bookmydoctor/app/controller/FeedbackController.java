package com.bookmydoctor.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmydoctor.app.exception.FeedBackException;
import com.bookmydoctor.app.model.FeedBack;
import com.bookmydoctor.app.service.ImplFeedbackService;

/**
 * @author rajan 
 *
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	ImplFeedbackService service;

	@PostMapping("/addFeedBack")
	public FeedBack addFeedBack(@RequestBody FeedBack fdb)   {
		FeedBack test = service.addFeedback(fdb);
//		if (test.getRating() == 0 || test.getFeedbackComment() == null || test.getFeedbackId() == 0 || (test.getRating()<1 && test.getRating()>10))  {
//			throw new FeedBackException("Enter values for feedback");
//		}
		
		return test;
	}

	@GetMapping("/getFeedBack/{id}")
	public Optional<FeedBack> getFeedBackById(@PathVariable("id") int feedbackId) {
		Optional<FeedBack> test = service.getFeedback(feedbackId);
		if (test.isEmpty()) {
			throw new FeedBackException("id is not present");
		}

		return service.getFeedback(feedbackId);
	}
	
}
