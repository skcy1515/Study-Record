# Controller, Service, Repository
![image](https://github.com/user-attachments/assets/dd9abe2d-431f-4dbc-91ad-fae669f55e52)

`MVC 패턴 처리 과정`
1. 클라이언트가 서버에 페이지를 요청한다.
2. Dispatcher Servlet은 사용자의 요청에 알맞는 @Controller를 찾는다.
3. 만약 DB데이터를 이용한 처리 과정이 없다면, 단순히 View를 보여주면 여기서 끝이다.
4. 만약 DB가 필요하다면 @Controller는 알맞은 @Service로 가서 비지니스 로직을 수행한다.
5. 수행하는 과정중 DB를 접근하기 위하여 @Repository에 요청하여 DB로 부터 필요한 값을 가져온다.
6. 순서대로 @Controller까지 결과값을 가지고 return을 하게 되며, Model에 담은 다음에 View를 찾아 보여준다.

### Component
@Component 어노테이션이 지정 되면 해당 객체는 Bean으로 등록되고 스프링 컨테이너가 해당 Bean을 관리하게 된다. 해당 기능을 스프링에서는 컴포넌트 스캔이라고 말한다.

### Controller
@Controller 라고 명시된 해당 클래스의 Mapping을 스캔한다. 

@Controller라고 명시가 되면, 해당 클래스는 @Component에 의해 자동으로 Bean이 등록된다. 클라이언트가 특정 요청을 하게 되면 처리하기 위해서 스프링은 제일 먼저 해당하는 Controller를 찾게 되는데 이때 @Controller라고 명시된 클래스들을 탐색한다. 그리고 난 다음에 Mapping주소가 일치하는 메소드의 내용을 실행하게 된다.

추가적으로 @RestController가 존재하는데, 이는 @ResponseBody를 사용한것과 동일하게 View를 반환하는게 아닌 객체(보통 JSON) 를 반환하게 된다.

### Bean
스프링에서 "Bean"은 스프링 IoC(Inversion of Control) 컨테이너에 의해 관리되는 객체를 의미한다. 쉽게 말해, 스프링 애플리케이션에서 사용되는 구성 요소(객체)를 가리키는 용어다. 스프링 빈은 애플리케이션의 런타임 동안 스프링 컨테이너에 의해 생성, 관리, 의존성 주입, 소멸 등의 생명주기를 관리받는다.

### Service
@Service 라고 명시된 클래스는 비지니스 로직에 대한 정보들이 담겨 있어야 한다. 즉 사용자의 요청에 따라서 DB에 접근하여 데이터를 추가, 삭제, 수정, 선택과 같은 요청을 처리할 수 있어야 한다. 

### Repository
@Repository 어노테이션은 해당 객체는 DB에서 CRUD와 같은 명렁을 하게 되며, 간단하게 DB 접근이 가능한 객체라고 생각하면 된다.
