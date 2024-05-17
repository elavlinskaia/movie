package com.example.movie.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movie", schema = "movies")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "movie_title")
    private String title;

    @Column(name = "movie_year")
    private Integer year;
    
}
