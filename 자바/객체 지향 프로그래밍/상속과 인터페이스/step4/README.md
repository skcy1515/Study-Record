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
  1 소스코드해설집
1 명품자바프로그래밍 생능출판사 1182 2011 황기태 김효수 0 15000
1 Power_JAVA 인피니티북스 3218 2012 천인국 하상호 0 14000
1 컴퓨터구조:정량적접근방식 홍릉과학출판사 3331 2008 JohnL.Hennessy 0 14000
1 컴퓨터구조 현우사 7761 2008 김천 이영식 임인선 0 12000
3 이산수학 한빛아카데미 1222 2013 박주미 0 15000
  2 이산수학연습문제해설 이산수학실행프로그램매뉴얼
4 플러스펜 0.5 800
4 Bic_round_stic 0.7 500
5 크리넥스 200 3200
5 여행용티슈 120 1200
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
	소스코드해설집 
[일반책]명품자바프로그래밍(생능출판사/1182/2011년)[15000원] 저자: 황기태 김효수
[일반책]Power_JAVA(인피니티북스/3218/2012년)[14000원] 저자: 천인국 하상호
[일반책]컴퓨터구조:정량적접근방식(홍릉과학출판사/3331/2008년)[14000원] 저자: JohnL.Hennessy
[일반책]컴퓨터구조(현우사/7761/2008년)[12000원] 저자: 김천 이영식 임인선
[부록책]이산수학(한빛아카데미/1222/2013년)[15000원] 저자: 박주미
	이산수학연습문제해설 이산수학실행프로그램매뉴얼 
플러스펜 0.5mm 800원
Bic_round_stic 0.7mm 500원
크리넥스 200장 3200원
여행용티슈 120장 1200원
검색 키워드:
```

# 설명
만약 앞에 숫자들로 구분하여 객체를 생성하고 싶다면? -> create 함수에 Scanner 객체를 인수로 받음
```
    @Override
    public Manageable create(Scanner filein) {
        Manageable item = null;
        int type = filein.nextInt();
        switch (type) {
            case 1:
                item = new Book();
                break;
            case 2:
                item = new EBook();
                break;
            case 3:
                item = new ABook();
                break;
            case 4:
                item = new Pen();
                break;
            case 5:
                item = new Tissue();
                break;
            default:
                break;
        }
        return item;
    }
```

```
    void readAll(String filename, Factory fac) {
        Scanner filein = openFile(filename);
        Manageable item = null;
        while (filein.hasNext()) {
            item = fac.create(filein);
            item.read(filein);
            mList.add(item);
        }
    }
```
