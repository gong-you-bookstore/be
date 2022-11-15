package com.bookstore.sharedBook.survey.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class SaveSurveyRequestDto {
    private String gender;
    private Integer yearOfBirth;
    private List<Integer> genre;
}
