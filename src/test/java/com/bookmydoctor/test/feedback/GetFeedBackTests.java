package com.bookmydoctor.test.feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bookmydoctor.app.dao.IFeedbackDao;
import com.bookmydoctor.app.model.FeedBack;
import com.bookmydoctor.app.service.ImplFeedbackService;
@SpringBootTest
public class GetFeedBackTests {
	@Autowired
	private ImplFeedbackService service;
	@MockBean
	private IFeedbackDao dao;
	
	@Test
	@DisplayName("Test:Get by Id")
	 public void GetFeedBackByIdtests() {
		Optional<FeedBack> getFeedback = Optional.of(new FeedBack("Average"));
		
		Mockito.when(dao.findById(getFeedback.get().getFeedbackId())).thenReturn(getFeedback);
		assertEquals(service.getFeedback(getFeedback.get().getFeedbackId()), getFeedback);

}
}