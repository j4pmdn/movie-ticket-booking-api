package com.hdoan.movie.repositories;

import com.hdoan.movie.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {

}
