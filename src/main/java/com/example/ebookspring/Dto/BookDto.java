package com.example.ebookspring.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class BookDto {

    private Long id;
    @NotEmpty(message = "Book bookName should not be empty!")
    private String bookName;
    @NotEmpty(message = "Book author should not be empty!")
    private String author;
    @NotEmpty(message = "Book description should not be empty!")
    private String description;
    @NotEmpty(message = "Photo link should not be empty!")
    private String photoURL;
    @NotEmpty(message = "Book price should not be empty!")
    private int price;
    private String demoVersion;
}
