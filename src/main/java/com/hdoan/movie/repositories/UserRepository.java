package com.hdoan.movie.repositories;


import com.hdoan.movie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
