package com.hdoan.movie.repositories;

import com.hdoan.movie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findByMovieName(String name);

}
