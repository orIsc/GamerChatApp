package com.gamerchatapp.demo.repository;

import com.gamerchatapp.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


}
