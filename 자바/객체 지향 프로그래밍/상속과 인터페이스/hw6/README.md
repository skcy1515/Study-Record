# 입력
```
201611012 김성관 010-9148-2689 2
201711311 김재훈 010-5511-1034 2
201710140 김원철 010-7757-1256 3
201910532 김준철 010-3215-1337 3
201910533 박우현 010-4855-8560 3
201711312 김동현 010-4856-8565 2
201710302 박태주 010-4856-8570 3
201910569 박성연 010-9148-2519 2
201810343 서민우 010-9124-2689 2
201910586 윤현주 010-9111-2689 2
201411012 이가영 010-7722-1256 3
201711170 이기원 010-7733-1256 2
201840148 이상훈 010-7755-1256 2
201711018 이종철 010-7788-1256 3
```

# 출력
```
201611012 김성관 010-9148-2689 (2학년)
201711311 김재훈 010-5511-1034 (2학년)
201710140 김원철 010-7757-1256 (3학년)
201910532 김준철 010-3215-1337 (3학년)
201910533 박우현 010-4855-8560 (3학년)
201711312 김동현 010-4856-8565 (2학년)
201710302 박태주 010-4856-8570 (3학년)
201910569 박성연 010-9148-2519 (2학년)
201810343 서민우 010-9124-2689 (2학년)
201910586 윤현주 010-9111-2689 (2학년)
201411012 이가영 010-7722-1256 (3학년)
201711170 이기원 010-7733-1256 (2학년)
201840148 이상훈 010-7755-1256 (2학년)
201711018 이종철 010-7788-1256 (3학년)
키워드:010-7
201710140 김원철 010-7757-1256 (3학년)
201411012 이가영 010-7722-1256 (3학년)
201711170 이기원 010-7733-1256 (2학년)
201840148 이상훈 010-7755-1256 (2학년)
201711018 이종철 010-7788-1256 (3학년)
키워드:이가영
201411012 이가영 010-7722-1256 (3학년)
키워드:2017
201711311 김재훈 010-5511-1034 (2학년)
201710140 김원철 010-7757-1256 (3학년)
201711312 김동현 010-4856-8565 (2학년)
201710302 박태주 010-4856-8570 (3학년)
201711170 이기원 010-7733-1256 (2학년)
201711018 이종철 010-7788-1256 (3학년)
키워드:end
```

# 설명
![image](https://github.com/user-attachments/assets/6b15947d-0d37-4545-845e-be5e09adebb8)

만약 학과(Department)에 서점(BookStore) 클래스까지 생긴다면? -> 코드 중복 (readAll, printAll, search...) 따라서 슈퍼 클래스를 만들어 공통 코드를 위로 올린다 -> Manager 추상 클래스

```
abstract public class Manager {
  ArrayList<Manageable> mList = new ArrayList<>();
  void readAll(String filename) { ...
  void printAll() { ...
  void search(Scanner scan) { ...
}
```

학과 클래스는 run 함수만 가지면 됨
```
class Department extends Manager {
  public static void main(String args[]) {
    Department main = new Department();
    main.run();
    }
  void run() {
    readAll(“student.txt”);
    printAll();
    search(scan);
  }
}
```

### Factory 패턴
```
void readAll(String filename) {
  Scanner filein = openFile(filename);
  Manageable m = null;
  while (filein.hasNext()) {
    m = new Manageable(); // 컴파일오류
    m.read(filein);
    mList.add(m);
  }
  filein.close();
}
```
인터페이스로 객체 생성이 불가하기 때문에 m이 Student 클래스를 가져야 할지 Book 클래스를 가져야 할지 모름 -> 그럴 때 사용하는게 Factory 패턴

```
interface Factory {
  public Manageable create();
}
```

```
class Department extends Manager implements Factory {
...
  @Override
  public Student create() {
    return new Student();
  }

  void run() {
  readAll(“student.txt”, this); // Department 객체가 Factory로 전달됨
  printAll();
  search();
}
```

```
void readAll(String filename, Factory fac) {
  Scanner filein = openFile(filename);
  Manageable m = null;
  while (filein.hasNext()) {
    m = fac.create(); // m = new Student()
    m.read(filein);
    mList.add(m);
  }
  filein.close();
}
```
