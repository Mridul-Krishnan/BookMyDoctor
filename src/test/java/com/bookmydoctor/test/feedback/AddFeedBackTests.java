package com.bookmydoctor.test.feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bookmydoctor.app.dao.IFeedbackDao;
import com.bookmydoctor.app.model.FeedBack;
import com.bookmydoctor.app.service.ImplFeedbackService;

import org.mockito.Mockito;

@SpringBootTest
class AddFeedBackTests {

	@Autowired
	private ImplFeedbackService service;
	@MockBean
	private IFeedbackDao repository;

	@Test
	@DisplayName("Test for adding new feedback details")
	void addFeedbackTest()
	{
		FeedBack feedback = new FeedBack("good");
		Mockito.when(repository.save(feedback)).thenReturn(feedback);
		assertEquals(service.addFeedback(feedback), feedback);
	}

}

