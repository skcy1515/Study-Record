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
