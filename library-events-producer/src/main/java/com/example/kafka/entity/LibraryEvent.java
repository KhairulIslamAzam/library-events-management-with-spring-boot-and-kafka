package com.example.kafka.entity;

import lombok.*;

/**
 * @author Khairul Islam Azam
 * @created 24/04/2021 - 10:57 PM
 * @project library events producer
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryEvent {

    private Integer libraryEventId;
    private Book book;

}
