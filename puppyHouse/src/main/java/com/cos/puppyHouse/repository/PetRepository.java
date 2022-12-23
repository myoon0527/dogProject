package com.cos.puppyHouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.puppyHouse.model.Pet;
import com.cos.puppyHouse.model.Users;


public interface PetRepository extends JpaRepository<Pet, Integer> {
}
