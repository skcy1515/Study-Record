# 배열
같은 타입의 데이터 여러 개를 저장하는 자료구조

```
int[] array = new int[size];
```

### 스트링 객체
```
String a = “class”;
```
문자열 생성하고 a가 그 객체를 가리킴

### 스트링 배열
```
String a = “class”;
String strArray[] = new String[4];
strArray[0] = a; // 참조, "class"
strArray[1] = “field”;
strArray[2] = “method”;
strArray[3] = “int”;
```

### 스트링 클래스 메소드
- .length() : 길이 반환
- `+` 연산 : 문자열 연결하기
- .substring() : 부분 문자열 반환
- .charAt(0) : 0번째 문자 반환하기

# 클래스
변수와 메소드를 묶어서 관리하는 소스코드 단위

객체 : 클래스의 필드에 대한 메모리 영역이 할당된 것

메소드: 객체.메소드()로 호출되는 함수

### 클래스 배열
```
// 배열 변수 선언
Student stList[];

// 학생수를 입력해 배열 생성
System.out.print("학생 수: ");
int n = scan.nextInt();
stList[] = new Student[n];
```
