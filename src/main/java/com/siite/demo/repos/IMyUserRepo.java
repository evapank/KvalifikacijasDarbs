package com.siite.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.siite.demo.models.MyUser;


public interface IMyUserRepo extends CrudRepository<MyUser, Integer>{

}
