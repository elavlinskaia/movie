package com.example.movie.mapper;

import org.mapstruct.Mapper;

import com.example.movie.dao.entity.Movie;
import com.example.movie.dto.MovieDto;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    
    MovieDto toDto(Movie source);

    Movie toEntity(MovieDto source);
}
