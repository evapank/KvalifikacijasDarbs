package com.siite.demo.services;

import com.siite.demo.models.MyUser;

public interface IMyUserCRUDservice {

	boolean insertNewUser(MyUser user);

	boolean deleteUserById(int userId);

	boolean updateUserById(int userId, MyUser user);

}
