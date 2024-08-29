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
com.example.review 패키지에 QuerydslConfig 클래스 추가
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
