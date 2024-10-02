package week4;

import java.util.Scanner;

public class Item {
    int num;         // 상품 번호, 순차적으로 생성
    String code;     // 상품 코드
    String name;     // 상품 이름
    int price;       // 상품 가격

    // 생성자: 상품 코드와 번호를 받아서 Item 객체를 초기화
    public Item(String code, int num) {
        this.code = code;
        this.num = num;
    }

    // 상품의 이름과 가격을 입력받는 메서드
    void read(Scanner scan) {
        name = scan.next();
        price = scan.nextInt();
    }

    // 상품 정보를 출력하는 메서드
    void print() {
        System.out.printf("[%d] %s %s %d\n", num, code, name, price);
    }

    // 상품 번호가 주어진 id와 일치하는지 확인하여 맞으면 true 아니면 false 반환
    boolean matchesId(int id) {
        return id == num;
    }

    // 상품 번호, 코드, 이름 중 하나라도 키워드와 일치하면 true 반환
    boolean matchesItem(String kwd) {
        return ("" + num).equals(kwd) || code.equals(kwd) || name.contains(kwd);
    }
}
