package com.cos.puppyHouse.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Notice")
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR3"
		, sequenceName = "USER_SEQ3"
		, initialValue = 1
		, allocationSize =  1
		)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity



public class NoticeFAQ {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR3")
	private int id;
	
	@Column(nullable=false, length=20, unique=true)
	private String noticeid;
	
	@Column(nullable=false, length=20)
	private String userid;
	
	@Column(nullable=false, length=40)
	private String title;
	
	@Column(nullable=false, length=100)
	private String content;
		
	@Column(nullable=false, length=30)
	private String createdate;

	@Enumerated(EnumType.STRING)
	private RoleType roles;
	
	@CreationTimestamp
	private Timestamp createDate;
}
