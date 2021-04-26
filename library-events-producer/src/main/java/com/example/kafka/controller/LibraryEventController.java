package com.example.kafka.controller;

import com.example.kafka.entity.LibraryEvent;
import com.example.kafka.producer.LibraryEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author Khairul Islam Azam
 * @created 24/04/2021 - 11:05 PM
 * @project library events producer
 */
@RestController
@Slf4j
public class LibraryEventController {

    @Autowired
    private LibraryEventProducer libraryEventProducer;

    @PostMapping("/v1/libraryevent")
    public ResponseEntity<LibraryEvent> saveLibraryEvent(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException, ExecutionException, InterruptedException {

        //invoking kafka producer
//        libraryEventProducer. sendLibraryEvent(libraryEvent);
        log.info("befor send");
//        SendResult<Integer, String> integerStringSendResult = libraryEventProducer.sendLibraryEventSynchronous(libraryEvent);
//        System.out.println(integerStringSendResult.toString());
        libraryEventProducer.sendLibraryEventV2(libraryEvent);
        log.info("after send");
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);

    }
}
