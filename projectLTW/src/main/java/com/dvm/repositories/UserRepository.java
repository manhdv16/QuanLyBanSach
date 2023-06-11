package com.dvm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvm.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
