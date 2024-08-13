# Lombok 설정하기
Lombok은 자바에서 반복적으로 작성해야 하는 보일러플레이트 코드를 줄이기 위해 사용하는 라이브러리다. 롬복을 사용하면 자주 사용하는 코드, 예를 들어 getter, setter, 생성자 등을 자동으로 생성해 주기 때문에 코드가 훨씬 간결하고 읽기 쉬워진다.
```
configurations {
  compileOnly {
    extendsFrom annotationProcessor
  }
}

dependencies {
  ...
  compileOnly 'org.projectlombok:lombok'
  annotationProcessor 'org.projectlombok:lombok'
  ...
}
```
build.gradle 파일에 들어가서 dependencies 위에 configurations 코드 추가하고 dependencies에 위에 코드 2줄 추가하고 오른쪽 위에 나타난 Road Gradle 버튼을 눌러주기, Lombok 플러그인을 설치한다.

![image](https://github.com/user-attachments/assets/657a60f6-f25d-4c35-84b8-4c9f5f3a7d5f)

이후 설정 -> 어노테이션 프로세서 탭에 들어가서 어노테이션 처리 활성화 버튼을 눌러준다.

```
@RestController
public class TestLombokApi {

    @GetMapping("/test/lombok")
    public TestLombokResponseBody testLombok() {
        return new TestLombokResponseBody("김찬영", 23);
    }

    @Getter
    @AllArgsConstructor
    public static class TestLombokResponseBody{
        String name;

        Integer age;
    }
}
```
@Getter, @AllArgsConstructor 어노테이션 덕분에 생성자와 getter 메서드를 따로 추가하지 않아도 된다.

# H2 데이터베이스와 JPA 추가하기
- `H2 데이터베이스` : 데이터베이스의 역할을 담당하며, 데이터를 저장하고 조회하는 시스템이다. H2는 개발과 테스트 환경에서 유용한 경량 데이터베이스로 자주 사용된다.
- `JPA` : H2 데이터베이스와 연결하여 자바 객체와 데이터베이스의 테이블 간의 매핑을 처리한다. JPA를 사용하면 자바 클래스와 데이터베이스 테이블 간의 데이터 변환을 자동으로 처리할 수 있다.
```
// build.gradle

dependencies {
  ...
  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  runtimeOnly 'com.h2database:h2'
  ...
}
```
```
// application.properties

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:rss
spring.datasource.username=sa
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```
buil.gradle에 의존성 코드 추가하고, src -> main -> resources -> application.properties 파일에 위에 코드를 추가한다.

![image](https://github.com/user-attachments/assets/7e738bfe-4eea-4182-9a48-07fe9060e88c)

![image](https://github.com/user-attachments/assets/76f74456-1791-484e-9dc7-405e94673f65)

이후 localhost:8080/h2-console 에 들어가서 JDBC URL은 `jdbc:h2:mem:rss`, User Name은 `sa`로 해주고 접속하여 정상적으로 들어가지는지 확인한다.

