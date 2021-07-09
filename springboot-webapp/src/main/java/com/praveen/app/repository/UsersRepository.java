package com.praveen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.app.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
