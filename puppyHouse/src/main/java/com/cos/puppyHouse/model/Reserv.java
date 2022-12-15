package com.cos.puppyHouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Reserv")
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR5"
		, sequenceName = "USER_SEQ5"
		, initialValue = 1
		, allocationSize = 1
		)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reserv {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR5")
	private int reservId;
	
	@Column(nullable=false, length=100)
	private String reservdate;
	
	@ManyToOne
	@JoinColumn(name="PetId")
	private Pet pet;
	
	@OneToOne
	@JoinColumn(name="teacherId")
	private Users users;
	
}
