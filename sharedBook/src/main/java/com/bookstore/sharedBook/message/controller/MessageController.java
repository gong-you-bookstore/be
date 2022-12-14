package com.bookstore.sharedBook.message.controller;

import com.bookstore.sharedBook.common.CommonResult;
import com.bookstore.sharedBook.common.ListResult;
import com.bookstore.sharedBook.common.ResponseService;
import com.bookstore.sharedBook.common.SingleResult;
import com.bookstore.sharedBook.message.dto.request.MessageBetweenRequestDto;
import com.bookstore.sharedBook.message.dto.request.MessageRequestDto;
import com.bookstore.sharedBook.message.dto.response.*;
import com.bookstore.sharedBook.message.facade.MessageFacadeImpl;
import com.bookstore.sharedBook.message.service.MessageServiceImpl;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/message")
public class MessageController {
    private final MessageServiceImpl messageService;
    private final MessageFacadeImpl messageFacade;
    private final ResponseService responseService;

    @PostMapping
    public ResponseEntity<CommonResult> sendMessage(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @Valid @RequestBody MessageRequestDto messageRequestDto){
        messageService.send(accessToken, messageRequestDto);
        return new ResponseEntity<>(responseService.getSimpleResult(true), HttpStatus.OK);
    }

    @GetMapping("/{shelfId}")
    public ResponseEntity<ListResult<MessageBetweenUserResponseDto>> getMessages(
            @RequestHeader("X-AUTH-TOKEN") String accessToken,
            @PathVariable String shelfId,
            @RequestParam String email1,
            @RequestParam String email2){
        return new ResponseEntity<>(responseService.getListResult(messageFacade.getAllMessagesByShelfId(accessToken, shelfId, email1, email2)), HttpStatus.OK);
    }

    @GetMapping("/box")
    public ResponseEntity<ListResult<MessageBoxResponseDto>> getAllMyMessages(
            @RequestHeader("X-AUTH-TOKEN") String accessToken){
        return new ResponseEntity<>(responseService.getListResult(messageFacade.getAllMyMessages(accessToken)), HttpStatus.OK);
    }


//    @GetMapping("/received")
//    public ResponseEntity<ListResult<MessageReceivedSimpleResponseDto>> getAllReceivedMessages(
//            @RequestHeader("X-AUTH-TOKEN") String accessToken){
//        return new ResponseEntity<>(responseService.getListResult(messageService.getAllReceivedMessages(accessToken)), HttpStatus.OK);
//    }
//
//    @GetMapping("/received/{messageId}")
//    public ResponseEntity<SingleResult<MessageReceivedDetailResponseDto>> getReceivedMessage(
//            @RequestHeader("X-AUTH-TOKEN") String accessToken,
//            @PathVariable String messageId){
//        return new ResponseEntity<>(responseService.getSingleResult(messageService.getReceivedMessageDetail(accessToken, messageId)), HttpStatus.OK);
//    }
//
//    @GetMapping("/sent")
//    public ResponseEntity<ListResult<MessageSentSimpleResponseDto>> getAllSentMessages(
//            @RequestHeader("X-AUTH-TOKEN") String accessToken){
//        return new ResponseEntity<>(responseService.getListResult(messageService.getAllSentMessages(accessToken)), HttpStatus.OK);
//    }
//
//    @GetMapping("/sent/{messageId}")
//    public ResponseEntity<SingleResult<MessageSentDetailResponseDto>> getSentMessage(
//            @RequestHeader("X-AUTH-TOKEN") String accessToken,
//            @PathVariable String messageId){
//        return new ResponseEntity<>(responseService.getSingleResult(messageService.getSentMessageDetail(accessToken, messageId)), HttpStatus.OK);
//    }
}
