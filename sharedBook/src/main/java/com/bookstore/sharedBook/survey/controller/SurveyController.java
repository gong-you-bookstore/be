package com.bookstore.sharedBook.survey.controller;

import com.bookstore.sharedBook.common.CommonResult;
import com.bookstore.sharedBook.common.ResponseService;
import com.bookstore.sharedBook.survey.dto.request.SaveSurveyRequestDto;
import com.bookstore.sharedBook.survey.facade.SurveyFacadeImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/survey")
public class SurveyController {
    private final SurveyFacadeImpl surveyFacade;
    private final ResponseService responseService;

    @PostMapping
    public ResponseEntity<CommonResult> saveSurvey(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @RequestBody SaveSurveyRequestDto saveSurveyRequestDto){
        surveyFacade.saveSurvey(accessToken, saveSurveyRequestDto);
        return new ResponseEntity<>(responseService.getSimpleResult(true), HttpStatus.OK);
    }
}
