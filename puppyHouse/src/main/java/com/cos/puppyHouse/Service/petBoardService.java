package com.cos.puppyHouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.puppyHouse.model.Pet;
import com.cos.puppyHouse.model.PetBoard;
import com.cos.puppyHouse.model.PetBoardRoleType;
import com.cos.puppyHouse.model.Users;
import com.cos.puppyHouse.repository.petBoardRepository;

@Service
public class petBoardService {
	
	@Autowired
	private petBoardRepository petBoardRepository;
	
	@Transactional
	public void 글쓰기(PetBoard petBoard,Pet pet, Users user ) {
		System.out.println("petBoardService 출력");
		petBoard.setUser(user);
		petBoard.setPet(pet);
		petBoardRepository.save(petBoard);
	}
	
	@Transactional(readOnly=true)
	public Page<PetBoard> 글목록(Pageable pageable, PetBoardRoleType roles){
		return petBoardRepository.findByRoles(roles,pageable);
	}
	
	@Transactional(readOnly=true)
	public PetBoard 글상세보기(int id) {
		return petBoardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
				});
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		petBoardRepository.deleteById(id);
	}
	

}
