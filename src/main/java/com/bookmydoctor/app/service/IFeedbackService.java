package com.bookmydoctor.app.service;

import java.util.List;
import java.util.Optional;

import com.bookmydoctor.app.model.Doctor;
import com.bookmydoctor.app.model.FeedBack;

public interface IFeedbackService {
	
	public FeedBack addFeedback(FeedBack fdb);
	public Optional<FeedBack> getFeedback(int feedbackId);
	public List<FeedBack> getAllFeedback(Doctor doc);

}
