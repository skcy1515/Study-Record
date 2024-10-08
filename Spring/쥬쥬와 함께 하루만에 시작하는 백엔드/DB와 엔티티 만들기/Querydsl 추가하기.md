# JPA 방식
# 설정 추가하기
build.gradle에 코드 추가
```
// build.gradle
dependencies {
  ...
  implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'
  annotationProcessor "com.querydsl:querydsl-apt:5.0.0:jakarta"
  annotationProcessor "jakarta.annotation:jakarta.annotation-api"
  annotationProcessor "jakarta.persistence:jakarta.persistence-api"
}
```

# QuerydslConfig
com.example.review 패키지에 [QuerydslConfig](https://github.com/skcy1515/Study-Record/blob/main/Spring/%EC%A5%AC%EC%A5%AC%EC%99%80%20%ED%95%A8%EA%BB%98%20%ED%95%98%EB%A3%A8%EB%A7%8C%EC%97%90%20%EC%8B%9C%EC%9E%91%ED%95%98%EB%8A%94%20%EB%B0%B1%EC%97%94%EB%93%9C/review/src/main/java/com/example/review/QuerydslConfig.java) 클래스 추가
```
@RequiredArgsConstructor
@Configuration
public class QuerydslConfig {

    private final EntityManager em;

    @Bean
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(em);
    }
}
```
- `@Configuration` : 이 어노테이션은 해당 클래스가 스프링의 설정 클래스임을 나타낸다.
- `private final EntityManager em;` : EntityManager는 JPA에서 엔티티를 관리하고 데이터베이스 연산을 수행하는 인터페이스다. 이 클래스에서는 EntityManager를 주입받아 사용한다.
- `@Bean` : 이 메서드가 스프링 컨테이너에서 관리하는 빈(Bean) 객체를 생성하는 메서드임을 나타낸다. 여기서는 JPAQueryFactory 객체를 빈으로 등록한다.
- `public JPAQueryFactory queryFactory()` : 이 메서드는 JPAQueryFactory 객체를 생성하여 반환한다. JPAQueryFactory는 Querydsl에서 쿼리를 생성할 때 사용하는 핵심 클래스다. 생성자에 EntityManager를 전달하여 JPA와의 연동을 가능하게 한다.

# TestRepositoryImpl, TestRepositoryCustom
repository 패키지에 각각 [TestRepositoryImpl](https://github.com/skcy1515/Study-Record/blob/main/Spring/%EC%A5%AC%EC%A5%AC%EC%99%80%20%ED%95%A8%EA%BB%98%20%ED%95%98%EB%A3%A8%EB%A7%8C%EC%97%90%20%EC%8B%9C%EC%9E%91%ED%95%98%EB%8A%94%20%EB%B0%B1%EC%97%94%EB%93%9C/review/src/main/java/com/example/review/repository/TestRepositoryImpl.java) 클래스, [TestRepositoryCustom](https://github.com/skcy1515/Study-Record/blob/main/Spring/%EC%A5%AC%EC%A5%AC%EC%99%80%20%ED%95%A8%EA%BB%98%20%ED%95%98%EB%A3%A8%EB%A7%8C%EC%97%90%20%EC%8B%9C%EC%9E%91%ED%95%98%EB%8A%94%20%EB%B0%B1%EC%97%94%EB%93%9C/review/src/main/java/com/example/review/repository/TestRepositoryCustom.java) 인터페이스를 만들어준다
```
@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl {
    private final JPAQueryFactory queryFactory;

    
}
```
- `@Repository` : 이 어노테이션은 스프링에서 해당 클래스가 데이터 접근 계층(DAO)의 역할을 하는 클래스임을 나타낸다. 스프링 컨테이너는 @Repository 어노테이션이 붙은 클래스를 빈으로 등록하고, 데이터베이스 관련 예외를 스프링의 데이터 접근 예외로 변환하는 등의 기능을 제공한다.
- `private final JPAQueryFactory queryFactory;` : JPAQueryFactory는 Querydsl을 사용하여 JPA 쿼리를 작성할 때 사용하는 핵심 객체다.

```
public interface TestRepositoryCustom {
}
```

# TestService, TestRepository
[TestService](https://github.com/skcy1515/Study-Record/blob/main/Spring/%EC%A5%AC%EC%A5%AC%EC%99%80%20%ED%95%A8%EA%BB%98%20%ED%95%98%EB%A3%A8%EB%A7%8C%EC%97%90%20%EC%8B%9C%EC%9E%91%ED%95%98%EB%8A%94%20%EB%B0%B1%EC%97%94%EB%93%9C/review/src/main/java/com/example/review/service/TestService.java) 클래스와 [TestRepository](https://github.com/skcy1515/Study-Record/blob/main/Spring/%EC%A5%AC%EC%A5%AC%EC%99%80%20%ED%95%A8%EA%BB%98%20%ED%95%98%EB%A3%A8%EB%A7%8C%EC%97%90%20%EC%8B%9C%EC%9E%91%ED%95%98%EB%8A%94%20%EB%B0%B1%EC%97%94%EB%93%9C/review/src/main/java/com/example/review/repository/TestRepository.java) 인터페이스에 코드를 추가해준다
```
    public List<TestEntity> findAllByNameByJPA(String name) {
        return testRepository.findAllByName(name);
    }
```
- `public List<TestEntity> findAllByNameByJPA(String name)` : 이 메서드는 TestEntity 객체들의 리스트를 반환하고, name이라는 문자열 매개변수를 인자로 받는다. 이 값은 조회할 때 사용할 조건이 된다.
- `return testRepository.findAllByName(name);` : 이 줄은 testRepository 객체의 findAllByName 메서드를 호출하여, name과 일치하는 TestEntity 객체들의 리스트를 반환한다.

```
public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {

    public List<TestEntity> findAllByName(String name);
}
```
- `extends TestRepositoryCustom` : TestRepository는 TestRepositoryCustom이라는 사용자 정의 인터페이스도 상속받는다. 이 부분은 기본적인 JPA 메서드 외에 추가적인 커스텀 메서드를 정의하거나 구현할 수 있는 확장 포인트를 제공한다.
- `public List<TestEntity> findAllByName(String name);` : 이 메서드는 name이라는 문자열 매개변수를 받아서, 그 이름과 일치하는 TestEntity 객체들의 리스트를 반환한다.

# TestQueryApi
api 패키지에 [TestQueryApi](https://github.com/skcy1515/Study-Record/blob/main/Spring/%EC%A5%AC%EC%A5%AC%EC%99%80%20%ED%95%A8%EA%BB%98%20%ED%95%98%EB%A3%A8%EB%A7%8C%EC%97%90%20%EC%8B%9C%EC%9E%91%ED%95%98%EB%8A%94%20%EB%B0%B1%EC%97%94%EB%93%9C/review/src/main/java/com/example/review/api/TestQueryApi.java) 클래스를 생성해준다.
```
@RequiredArgsConstructor
@RestController
public class TestQueryApi {
    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJpa() {
        return testService.findAllByNameByJPA("찬영");
    }
}
```

![image](https://github.com/user-attachments/assets/71f2d138-b1f6-4e4b-a331-4685d1640045)

이후 postman에 들어가서 찬영이라는 이름으로 create를 해주고 http://localhost:8080/test/query/jpa 를 통해 쿼리가 되는지 확인한다.

# Querydsl 방식
# TestRepositoryCustom
코드 추가
```
public interface TestRepositoryCustom {

    public List<TestEntity> findAllByNameByQuerydsl(String name);
}
```

# TestRepositoryImpl
코드 추가
```
public class TestRepositoryImpl implements TestRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory.selectFrom(QTestEntity.testEntity)
                .fetch();
    }
}
```
- ` queryFactory.selectFrom(QTestEntity.testEntity)` : QueryDSL을 사용하여 TestEntity의 모든 레코드를 선택하는 쿼리를 만든다. QTestEntity는 QueryDSL이 생성한 클래스이다.
- `.fetch()` : 쿼리를 실행하고 결과를 리스트로 반환한다.

# TestService, TestQueryApi
코드 추가
```
    public List<TestEntity> findAllByNameByQuerydsl(String name){
        return testRepository.findAllByNameByQuerydsl(name);
    }
```

```
    @GetMapping("/test/query/querydsl")
    public List<TestEntity> queryQuerydsl() {
        return testService.findAllByNameByQuerydsl("찬영");
    }
```
