package com.cos.puppyHouse.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="pet")
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR2"
		, sequenceName = "USER_SEQ2"
		, initialValue = 1
		, allocationSize = 1
		)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR2")
	private int petId;
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="UsersId")
	private Users users;
	
	@Column(length=30)
	private String petName;
	
	@Column(length=100)
	private String species;
	
	@Column(length=30)
	private int age;
	
	@Column(length=30)
	private String gender;
	
	@Column(length=30)
	private String weight;
	
	@Column(length=100)
	private String allergy;
	
	@Column(length=100)
	private String etc;
	
	@Column(length=30)
	private String neutered;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	//이미지 필드
	private String imgOriName;
	
	private String imgName;
	
	private String imgUrl;
}