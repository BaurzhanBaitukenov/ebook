package com.example.ebookspring.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String photourl;
    private String password;
}
