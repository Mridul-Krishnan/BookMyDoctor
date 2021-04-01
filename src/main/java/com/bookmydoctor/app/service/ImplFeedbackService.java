package com.bookmydoctor.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmydoctor.app.dao.IFeedbackDao;
import com.bookmydoctor.app.model.Doctor;
import com.bookmydoctor.app.model.FeedBack;

/**
 * @author rajan
 *
 */
@Service
public class ImplFeedbackService implements IFeedbackService {
	@Autowired
	private IFeedbackDao dao;

	@Override
	public FeedBack addFeedback(FeedBack fdb) {

		return dao.save(fdb);
	}

	@Override
	public Optional<FeedBack> getFeedback(int feedbackId) {

		return dao.findById(feedbackId);
	}

	@Override
	public List<FeedBack> getAllFeedback(Doctor doc) {

		return dao.findAll();
	}

	

}
