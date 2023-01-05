package com.cos.puppyHouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.puppyHouse.model.PetBoard;
import com.cos.puppyHouse.model.PetBoardRoleType;

public interface PetBoardRepository extends JpaRepository<PetBoard,Integer> {
	
	public List<PetBoard> findByRoles(PetBoardRoleType roles);
}
