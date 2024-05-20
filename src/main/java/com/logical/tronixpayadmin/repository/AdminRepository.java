package com.logical.tronixpayadmin.repository;

import com.logical.tronixpayadmin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin,Integer>{

	public Admin findByEmail(String email);

	public boolean findByEmailAndPassword(String email, String password);

	public boolean existsByEmail(String lowerCase);

	public boolean existsByEmailAndPassword(String email, String password);

	public boolean existsById(int adminId);
}
