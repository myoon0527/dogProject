package com.cos.puppyHouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.puppyHouse.model.Pet;
import com.cos.puppyHouse.model.Users;
import com.cos.puppyHouse.repository.PetRepository;
import com.cos.puppyHouse.repository.UserRepository;


@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	@Transactional
	public void 펫등록(Pet pet) {
		
		Pet persistance = petRepository.findById(pet.getPetId()).orElseThrow(() -> {
			return new IllegalArgumentException("강아지 등록 실패");
		});
		
		persistance.setPetName(pet.getPetName());
		persistance.setSpecies(pet.getSpecies());
		persistance.setAge(pet.getAge());
		persistance.setGender(pet.getGender());
		persistance.setWeight(pet.getWeight());
		persistance.setAllergy(pet.getAllergy());
		persistance.setEtc(pet.getEtc());
		persistance.setNeutered(pet.getNeutered());
	}
	
	
	public Pet 강아지수첩상세보기(int petId) {
		System.out.println("상세보기 서비스 호출");
		return petRepository.findById(petId).orElseThrow(()->{
			return new IllegalArgumentException("에러남아아아");
		});
	}
	
}
