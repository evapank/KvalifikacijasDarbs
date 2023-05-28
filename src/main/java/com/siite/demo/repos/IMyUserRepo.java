package com.siite.demo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siite.demo.models.MyUser;


public interface IMyUserRepo extends JpaRepository<MyUser, Integer>{

	boolean existsByEmail(String email);

	MyUser findByIdUser(int userId);

	Optional<MyUser> findByUsername(String username);

}


