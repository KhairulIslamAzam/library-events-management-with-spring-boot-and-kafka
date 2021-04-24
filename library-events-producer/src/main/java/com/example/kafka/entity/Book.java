package com.example.kafka.entity;

import lombok.*;

/**
 * @author Khairul Islam Azam
 * @created 24/04/2021 - 10:51 PM
 * @project library events producer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private Integer bookId;
    private String bookName;
    private String bookAuthor;

}
