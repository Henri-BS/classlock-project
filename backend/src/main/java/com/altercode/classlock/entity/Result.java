package com.altercode.classlock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_result")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "result_id")
	private Long id;

	@Column(name = "total_correct")
	private Integer totalCorrect = 0;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
		
	public Result() {

	}

	public Result(Long id, Integer totalCorrect, User user) {
		this.id = id;
		this.totalCorrect = totalCorrect;
		this.user = user; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTotalCorrect() {
		return totalCorrect;
	}

	public void setTotalCorrect(Integer totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
