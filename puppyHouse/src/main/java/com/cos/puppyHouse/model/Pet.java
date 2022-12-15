package com.cos.puppyHouse.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="pet")
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR2"
		, sequenceName = "USER_SEQ2"
		, initialValue = 1
		, allocationSize = 1
		)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR2")
	private int petId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="UsersId")
	private Users users;
	
	@Column(nullable=false, length=100)
	private String species;
	
	@Column(nullable=false, length=30)
	private int age;
	
	@Column(nullable=false, length=30)
	private String gender;
	
	@Column(length=100)
	private String allergy;
	
	@Column(length=100)
	private String etc;
	
	@Column(nullable=false, length=30)
	private String neutered;
	
	@Column(nullable=false, length=50)
	private String petImg;
	
	@CreationTimestamp
	private Timestamp createDate;
}