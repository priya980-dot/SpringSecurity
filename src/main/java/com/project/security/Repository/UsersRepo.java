package com.project.security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.security.Model.Users;

@Repository
public interface UsersRepo  extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);

}
