package com.shobhit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shobhit.entity.User;
import com.shobhit.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
		userRepository.saveUser(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	public User findUser(int userId) {
		return userRepository.findUser(userId);
	}

	public void deleteUser(int userId) {
		userRepository.deleteUser(userId);
	}
}