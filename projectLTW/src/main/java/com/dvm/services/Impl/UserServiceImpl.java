package com.dvm.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvm.entity.User;
import com.dvm.repositories.UserRepository;
import com.dvm.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User entity) {
		entity.setRole("user");
		return userRepository.save(entity);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		Optional<User> optionalUser = findById(username);
		if(optionalUser.isPresent()) {
			if(optionalUser.get().getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean checkUserExisted(String username) {
		if(findById(username).isPresent()) {
			return false;
		}
		return true;
	}
	
}
