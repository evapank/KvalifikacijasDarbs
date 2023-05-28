package com.siite.demo.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siite.demo.models.MyWebsite;

public interface IMyWebsiteRepo extends JpaRepository<MyWebsite, Integer>{

	ArrayList<MyWebsite> findByOwnerIdUser(int userId);

	MyWebsite findByIdWeb(int websiteId);

}

