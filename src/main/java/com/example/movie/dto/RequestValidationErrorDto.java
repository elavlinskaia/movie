package com.example.movie.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestValidationErrorDto {
    private List<FieldValidationErrorDto> error;
}
