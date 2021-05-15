# Lombok

Lombok을 사용하기 위해서 settings.gradle에 Lombok 의존성을 추가해줘야함

Lombok은 어노테이션을 활용하여 소스코드를 간단하게 만들어준다

```java
package com.example.bookmanager.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 게터와 세터를 자동생성해주는 Lombok의 어노테이션
@Getter
@Setter
// ToString 오버라이딩
@ToString
// 생성자 관련 어노테이션
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 멤버변수 세팅해주는 생성자
@RequiredArgsConstructor // @NonNull 멤버변수만 세팅해주는 생성자
//해쉬코드 만들어준다
@EqualsAndHashCode
//Getter, Setter, ToString, EqualsAndHashCode 기능이 모두 포함
@Data
public class User {
    @NonNull // 널값을 넣을 수 없다
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}

```

