package com.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ticket_title")
	private String ticketTitle;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "content")
	private String content;

	@Column(name = "created_on")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;
}