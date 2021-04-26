package com.example.kafka.controller;

import com.example.kafka.entity.LibraryEvent;
import com.example.kafka.entity.LibraryEventType;
import com.example.kafka.producer.LibraryEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<LibraryEvent> saveLibraryEvent(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException{

        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
        libraryEventProducer.sendLibraryEventV2(libraryEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);

    }

    @PutMapping("/v1/libraryevent")
    public ResponseEntity<?> updateLibraryEvent(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException{

        if(libraryEvent.getLibraryEventId() == null){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("libraryId {} null"+libraryEvent.getLibraryEventType());
        }

        libraryEvent.setLibraryEventType(LibraryEventType.UPDATE);
        libraryEventProducer.sendLibraryEventV2(libraryEvent);
        return ResponseEntity.status(HttpStatus.OK).body(libraryEvent);

    }
}
