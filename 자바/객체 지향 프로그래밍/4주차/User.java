package week4;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String name;            // 사용자 이름
    String pwd;             // 사용자 비밀번호
    int pt;                 // 사용자 포인트
    int idCounter = 0;      // 구매한 상품의 수
    int totalPrice = 0;     // 총 구매 가격
    ArrayList<Item> items = new ArrayList<>();  // 사용자가 구매한 상품 목록

    // 생성자: 사용자 이름을 받아서 User 객체를 초기화
    public User(String name) {
        this.name = name;
    }

    // 사용자 정보를 입력받는 메서드 (비밀번호와 포인트)
    void read(Scanner scan) {
        pwd = scan.next();
        pt = scan.nextInt();
    }

    // 사용자가 상품을 구매할 때, 상품을 추가하고 포인트를 계산
    void addItem(Item item) {
        totalPrice += item.price;     // 총 구매 가격에 상품 가격 추가
        items.add(item);              // 구매한 상품을 목록에 추가
        idCounter++;                  // 구매한 상품 수 증가

        pt += item.price / 100;       // 구매 금액에 따라 포인트 증가
    }

    // 사용자가 상품의 ID를 토대로 구매한 상품 목록을 추가하는 메서드
    void addId(Store store, Scanner scan) {
        while (true) {
            int id = scan.nextInt();  // 구매할 상품 ID 입력
            if (id == 0) break;       // ID가 0이면 입력 종료

            Item item = store.findItemById(id);  // 상품 ID로 상품을 찾음
            if (item != null) {
                addItem(item);  // 상품이 존재하면 사용자에게 추가
            }
        }
    }

    // 사용자 정보를 출력하는 메서드
    void print() {
        System.out.printf("[%s] 총구매 %d건 %d원 (%d점)\n", name, idCounter, totalPrice, pt);
        for (Item item : items) {
            System.out.print(item.name + " ");  // 구매한 상품 이름 출력
        }
        System.out.println();
    }
}
