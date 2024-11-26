package com.hdoan.movie.repositories;

import com.hdoan.movie.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    Theater findByAddress(String address);

}
