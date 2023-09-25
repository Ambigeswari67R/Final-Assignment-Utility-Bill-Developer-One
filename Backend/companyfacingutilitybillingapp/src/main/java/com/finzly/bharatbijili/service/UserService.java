package com.finzly.bharatbijili.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.bharatbijili.dao.UserDao;
import com.finzly.bharatbijili.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public List<User> getUserById(Long userId) {
		return userDao.getUserById(userId);
	}

	public String createUser(User user) {
		return userDao.createUser(user);
	}

	public String updateUser(Long userId, User updatedUser) {
		return userDao.updateUser(userId, updatedUser);
	}

	public String deleteUser(Long userId) {
		return userDao.deleteUser(userId);
	}

	public String userLogin(User user) {
		List<User> list = userDao.getAllUsers();
		System.out.println(user.getEmployeeId());
		System.out.println(user.getOtp());

		for (User u : list) {
			if (u.getEmployeeId().equals(user.getEmployeeId()) && u.getOtp().equals(user.getOtp())) {
				return "{\"result\":\"Valid User\",\"id\":\"" + u.getEmployeeId() + "\"}";
			}

		}
		return "{\"result\":\"InValid User\"}";
	}

}
