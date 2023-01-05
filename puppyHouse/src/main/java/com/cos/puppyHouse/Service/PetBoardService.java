package com.cos.puppyHouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.puppyHouse.model.Pet;
import com.cos.puppyHouse.model.PetBoard;
import com.cos.puppyHouse.model.PetBoardRoleType;
import com.cos.puppyHouse.model.Users;
import com.cos.puppyHouse.repository.PetBoardRepository;
import com.cos.puppyHouse.repository.PetRepository;

@Service
public class PetBoardService {
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetBoardRepository petBoardRepository;
	
	@Transactional
	public void diaryWrite(int petId, PetBoard petBoard, Users user) {
		Pet pet= petRepository.findById(petId)
				.orElseThrow(()->{
					return new IllegalArgumentException("일치하는 펫 정보를 찾을 수 없습니다.");
				});
		
		petBoard.setUser(user);
		petBoard.setPet(pet);
		petBoardRepository.save(petBoard);
	}
	
	@Transactional
	public List<PetBoard> 글목록(PetBoardRoleType roles){
		return petBoardRepository.findByRoles(roles);
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		petBoardRepository.deleteById(id);
	}
}
