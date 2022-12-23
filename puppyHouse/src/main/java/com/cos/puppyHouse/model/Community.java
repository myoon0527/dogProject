package com.cos.puppyHouse.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="community")
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR1"
		, sequenceName = "USER_SEQ1"
		, initialValue = 1
		, allocationSize = 1
		)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Community {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR1")
	private int commuId;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob
	private String content;
	
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER)
	
	@JoinColumn(name="UsersId")
	private Users users;
	
	@OneToMany (mappedBy="community", fetch = FetchType.EAGER)
	
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
