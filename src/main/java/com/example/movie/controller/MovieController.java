package com.example.movie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.dao.entity.Movie;
import com.example.movie.dto.MovieDto;
import com.example.movie.mapper.MovieMapper;
import com.example.movie.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
@Tag(name = "БД фильмов", description = "Управляет БД фильмов")
public class MovieController {

    private final MovieService service;
    private final MovieMapper mapper;

    @GetMapping("")
    @Operation(summary = "Список фильмов", description = "Позволяет получить список всех фильмов")
    public List<MovieDto> findAll() {
        log.trace("Получен запрос всех фильмов");
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Получение фильма", description = "Позволяет получить запись о фильме по ID")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id) {
        log.trace("Получен запрос фильма [{}]", id);
        return ResponseEntity.of(service.findById(id).map(mapper::toDto));
    }

    @PostMapping("")
    @Operation(summary = "Создание фильма", description = "Позволяет создать запись о фильме")
    public MovieDto create(@RequestBody @Valid MovieDto movieDto) {
        Movie persistedMovie = service.save(mapper.toEntity(movieDto));
        return mapper.toDto(persistedMovie);
    }
    
}
