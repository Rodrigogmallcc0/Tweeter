package com.twitter.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twitter.demo.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
