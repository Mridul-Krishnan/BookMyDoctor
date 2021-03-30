package com.bookmydoctor.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmydoctor.app.model.FeedBack;
@Repository
public interface IFeedbackDao extends JpaRepository<FeedBack, Integer> {


}
