package com.finzly.bharatbijili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.bharatbijili.service.UserService;
import com.finzly.bharatbijili.entity.User;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String userLogin(@RequestBody User user) {
		return userService.userLogin(user);

	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{userId}")
	public List<User> getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}

	@PostMapping
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{userId}")
	public String updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
		return userService.updateUser(userId, updatedUser);
	}

	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		return userService.deleteUser(userId);
	}

}
