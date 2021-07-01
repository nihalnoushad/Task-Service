package com.ust.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_Id")
	private Integer id;
	@Column(name = "role_id")
	private Integer role_id;
	@Column(name = "task_name")
	private String task_name;
	@Column(name = "task_Descreption")
	private String task_Descreption;
	@Column(name = "task_start_date")
	private LocalDate task_start_date;
	@Column(name = "task_end_date")
	private LocalDate task_end_date;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_Descreption() {
		return task_Descreption;
	}

	public void setTask_Descreption(String task_Descreption) {
		this.task_Descreption = task_Descreption;
	}

	public LocalDate getTask_start_date() {
		return task_start_date;
	}

	public void setTask_start_date(LocalDate task_start_date) {
		this.task_start_date = task_start_date;
	}

	public LocalDate getTask_end_date() {
		return task_end_date;
	}

	public void setTask_end_date(LocalDate task_end_date) {
		this.task_end_date = task_end_date;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + id + ", role_id=" + role_id + ", task_name=" + task_name + ", task_Descreption="
				+ task_Descreption + ", task_start_date=" + task_start_date + ", task_end_date=" + task_end_date + "]";
	}

}
