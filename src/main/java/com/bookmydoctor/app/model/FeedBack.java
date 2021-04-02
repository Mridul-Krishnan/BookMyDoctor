package com.bookmydoctor.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author rajan
 *
 */
@Entity
public class FeedBack {

	@Id
	@GeneratedValue
	public int feedbackId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "patientId", referencedColumnName = "patientId")
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
	private Doctor doctor;
	public int rating;

	public FeedBack(int rating, String feedbackComment) {
		super();
		this.rating = rating;
		this.feedbackComment = feedbackComment;
	}

	private String feedbackComment;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedbackComment() {
		return feedbackComment;
	}

	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}

	

	public FeedBack(Patient patient, Doctor doctor, int rating, String feedbackComment) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.rating = rating;
		this.feedbackComment = feedbackComment;
	}

	public FeedBack(int feedbackId, Patient patient, Doctor doctor, int rating, String feedbackComment) {
		super();
		this.feedbackId = feedbackId;
		this.patient = patient;
		this.doctor = doctor;
		this.rating = rating;
		this.feedbackComment = feedbackComment;
	}

	public FeedBack(String string) {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
