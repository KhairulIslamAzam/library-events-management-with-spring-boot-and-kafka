package com.example.kafka.controller;

import com.example.kafka.entity.LibraryEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Khairul Islam Azam
 * @created 24/04/2021 - 11:05 PM
 * @project library events producer
 */
@RestController
public class LibraryEventController {

    @PostMapping("/v1/libraryevent")
    public ResponseEntity<LibraryEvent> saveLibraryEvent(@RequestBody LibraryEvent libraryEvent){

        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }
}
