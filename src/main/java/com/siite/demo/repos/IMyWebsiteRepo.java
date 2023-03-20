package com.siite.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.siite.demo.models.MyWebsite;

public interface IMyWebsiteRepo extends CrudRepository<MyWebsite, Integer>{

}
