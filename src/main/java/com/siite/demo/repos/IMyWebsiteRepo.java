package com.siite.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.siite.demo.models.MyWebsite;

public interface IMyWebsiteRepo extends CrudRepository<MyWebsite, Integer>{

	ArrayList<MyWebsite> findByOwnerIdUser(int userId);

}
