package com.logical.tronixpayadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logical.tronixpayadmin.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
