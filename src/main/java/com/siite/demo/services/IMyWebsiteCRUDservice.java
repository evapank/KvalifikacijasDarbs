package com.siite.demo.services;

import com.siite.demo.models.MyWebsite;

public interface IMyWebsiteCRUDservice {
	
	public boolean insertNewWebsite(MyWebsite website);
	
	public boolean deleteWebsiteById(int websiteId);
	
	public boolean updateWebsiteById(int websiteId, MyWebsite website);
	
	public MyWebsite readWebsiteById(int websiteId) throws Exception;

}
