package com.dvm.services;

import java.util.List;
import java.util.Optional;

import com.dvm.entity.User;

public interface UserService {

	void delete(User entity);

	void deleteById(String id);

	long count();

	Optional<User> findById(String id);

	List<User> findAll();

	User save(User entity);

	boolean checkLogin(String username,String password);

	boolean checkUserExisted(String username);
}
