package com.altercode.classlock.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ResultPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Result result;
	
	@ManyToOne
	@JoinColumn(name = "result_id")
	private User user;
	
	private List<Question> questions;
	
	public ResultPK() {
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
