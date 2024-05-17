package com.example.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.dao.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
