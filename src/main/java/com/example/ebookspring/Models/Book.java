package com.example.ebookspring.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private String author;
    private String description;
    private String photoURL;
    private int price;
    private String demoVersion;
//    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
//    public List<Comment> comments;
}
