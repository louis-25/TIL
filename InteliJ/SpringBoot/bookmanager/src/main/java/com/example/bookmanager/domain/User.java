package com.example.bookmanager.domain;

import lombok.*;

import java.time.LocalDateTime;

//게터와 세터를 자동생성해주는 Lombok의 어노테이션
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
