# 입력
```
2 자료구조 생능출판 1001 2003 천인국 공용해 하상호 0  15000
  http://www.sangreung.co.kr/computer/chun/datastructure PDF
1 전자계산기구조 양서각 1321 2013 진달복 0  13500
2 C언어의정석 글로벌 2831 2013 이창현 0  13000
  http://www.global.co.kr/c_jungsuk2013 EPUB
1 C언어콘서트 생능출판사 3121 2010 천인국 0 12000
1 열혈자료구조 오렌지미디어 9918 2012 윤성우 0 18000
3 JAVA의정석 도우출판 8655 2010 남궁성 0 17000
  1 소스코드해설집1
1 명품자바프로그래밍 생능출판사 1182 2011 황기태 김효수 0 15000
1 Power_JAVA 인피니티북스 3218 2012 천인국 하상호 0 14000
1 컴퓨터구조:정량적접근방식 홍릉과학출판사 3331 2008 JohnL.Hennessy 0 14000
1 컴퓨터구조 현우사 7761 2008 김천 이영식 임인선 0 12000
3 이산수학 한빛아카데미 1222 2013 박주미 0 15000
  2 이산수학연습문제해설 이산수학실행프로그램매뉴얼
```
# 출력
```
[전자책]자료구조(생능출판/1001/2003년)[15000원] 저자: 천인국 공용해 하상호
	http://www.sangreung.co.kr/computer/chun/datastructure [PDF]
[일반책]전자계산기구조(양서각/1321/2013년)[13500원] 저자: 진달복
[전자책]C언어의정석(글로벌/2831/2013년)[13000원] 저자: 이창현
	http://www.global.co.kr/c_jungsuk2013 [EPUB]
[일반책]C언어콘서트(생능출판사/3121/2010년)[12000원] 저자: 천인국
[일반책]열혈자료구조(오렌지미디어/9918/2012년)[18000원] 저자: 윤성우
[부록책]JAVA의정석(도우출판/8655/2010년)[17000원] 저자: 남궁성
	소스코드해설집1 
[일반책]명품자바프로그래밍(생능출판사/1182/2011년)[15000원] 저자: 황기태 김효수
[일반책]Power_JAVA(인피니티북스/3218/2012년)[14000원] 저자: 천인국 하상호
[일반책]컴퓨터구조:정량적접근방식(홍릉과학출판사/3331/2008년)[14000원] 저자: JohnL.Hennessy
[일반책]컴퓨터구조(현우사/7761/2008년)[12000원] 저자: 김천 이영식 임인선
[부록책]이산수학(한빛아카데미/1222/2013년)[15000원] 저자: 박주미
	이산수학연습문제해설 이산수학실행프로그램매뉴얼 
검색 키워드: 전자책
[전자책]자료구조(생능출판/1001/2003년)[15000원] 저자: 천인국 공용해 하상호
	http://www.sangreung.co.kr/computer/chun/datastructure [PDF]
[전자책]C언어의정석(글로벌/2831/2013년)[13000원] 저자: 이창현
	http://www.global.co.kr/c_jungsuk2013 [EPUB]
검색 키워드: 부록책
[부록책]JAVA의정석(도우출판/8655/2010년)[17000원] 저자: 남궁성
	소스코드해설집1 
[부록책]이산수학(한빛아카데미/1222/2013년)[15000원] 저자: 박주미
	이산수학연습문제해설 이산수학실행프로그램매뉴얼 
검색 키워드: 소스코드
[부록책]JAVA의정석(도우출판/8655/2010년)[17000원] 저자: 남궁성
	소스코드해설집1 
검색 키워드: end
```

# 설명
```
static String bookType = "일반책"; // Book
static String bookType = "부록책"; // ABook
static String bookType = "전자책"; // EBook
```
Book, EBook, ABook 클래스의 bookType 변수를 static으로 두는 이유 -> 각 객체마다 따로 가지고 있으면 메모리 낭비가 심하기 때문에 각 객체가 가지는 공통된 값이므로 static으로 선언한다. 

```
    // Book
    boolean matches(String kwd) {
        if (name.contains(kwd)) return true;
        if (pub.equals(kwd)) return true;
        if (isbn.equals(kwd)) return true;
        if (("" + year).equals(kwd)) return true;
        for (String a : authors)
            if (a.contains(kwd)) return true;
        if (getBookType().equals(kwd)) return true;
        return false;
    }

    // EBook
    @Override
    boolean matches(String kwd) {
        if (super.matches(kwd)) return true;
        if (url.contains(kwd)) return true;
        if (format.equals(kwd)) return true;
        return false;
    }
```
그런데 만약 bookType.equals(kwd)를 super 메소드에 둔다면? static 필드는 인스턴스가 아닌 클래스 단위로 관리되기 때문에, 상속받은 클래스에서 부모 클래스의 메서드를 호출할 때 부모 클래스의 bookType이 출력된다. 
따라서 가상함수 getBookType 메소드를 Book, EBook, ABook 클래스에 만들어준다.


```
String getBookType() {
  return bookType;
}
```
getBookType() 메서드는 클래스 자체에 속한 static 변수인 bookType을 참조하고 있으며, 이는 인스턴스가 아닌 클래스 수준에서 관리되기 때문에 호출 시 해당 클래스의 static 변수 값이 반환된다.
