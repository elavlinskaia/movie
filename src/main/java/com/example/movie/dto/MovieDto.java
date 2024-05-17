package com.example.movie.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    
    private Long id;
    
    @NotNull(message = "Название является обязательным")
    private String title;

    @Min(value = 1980L, message = "Только новые фильмы")
    private Integer year;
}
