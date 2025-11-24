package com.sangmi.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sangmi.crud.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
