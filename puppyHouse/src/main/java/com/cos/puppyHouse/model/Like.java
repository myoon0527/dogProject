package com.cos.puppyHouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SequenceGenerator(
		name = "USER_SEQ_GENERATOR7"
		, sequenceName = "USER_SEQ7"
		, initialValue = 1
		, allocationSize = 1
		)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="likes")
@Entity
public class Like {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR7")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "CommunityId")
	private Community community;
	
	@ManyToOne
	@JoinColumn(name = "UsersId", unique=true)
	private Users users;
}
