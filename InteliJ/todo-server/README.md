# todo-server

<br>

## Gradle세팅

plugins와 dependencies를 아래와 같이 세팅

```xml-dtd
plugins {
    id 'org.springframework.boot' version '2.4.2'
    id 'io.spring.dependency-management' version '1.0.11.RELEASE'
    id 'java'
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-rest'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

    runtimeOnly 'com.h2database:h2' // h2데이터베이스

    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")
}
```

