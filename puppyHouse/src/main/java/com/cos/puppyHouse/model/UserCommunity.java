package com.cos.puppyHouse.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserCommunity implements Serializable{

	@Column(name = "CommunityId")
	private Community community;
	
	@Column(name = "UsersId")
	private Users users;
}
