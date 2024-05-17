package com.example.movie.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.movie.dao.MovieRepository;
import com.example.movie.dao.entity.Movie;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // для всех private final
public class MovieService {

    private final MovieRepository repository;

    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return repository.findAll();

    }

    @Transactional(readOnly = true)
    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Movie save(Movie movie) {
        return repository.save(movie);
    }
}
