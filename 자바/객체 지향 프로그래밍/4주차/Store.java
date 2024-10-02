package week4;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> items = new ArrayList<>();  // 전체 상품 목록
    ArrayList<User> users = new ArrayList<>();  // 전체 사용자 목록

    // 메인 함수에서 실행할 메서드
    void mymain() {
        readAllItems();  // 모든 상품 정보를 입력받음
        readAllUsers();  // 모든 사용자 정보를 입력받음
        mainMenu();      // 메인 메뉴 실행
    }

    // 모든 상품 정보를 입력받는 메서드
    void readAllItems() {
        int num = 1; // 상품 번호 1부터 시작
        while (true) {
            String code = scan.next();   // 상품 코드 입력
            if (code.equals("0")) break; // 코드가 0이면 입력 종료

            Item item = new Item(code, num); // 새로운 상품 생성
            item.read(scan);                 // 상품의 이름과 가격 입력
            items.add(item);                 // 상품을 배열에 추가
            num++;                           // 번호 증가
        }
    }

    // 모든 사용자의 정보를 출력하는 메서드
    void printAllUsers() {
        for (User user : users) {
            user.print();
        }
    }

    // 모든 상품 정보를 출력하는 메서드
    void printAllItems() {
        for (Item item : items) {
            item.print();
        }
    }

    // 모든 사용자 정보를 입력받는 메서드
    void readAllUsers() {
        while (true) {
            String name = scan.next();   // 사용자 이름 입력
            if (name.equals("0")) break; // 이름이 0이면 입력 종료

            User user = new User(name);  // 새로운 사용자 생성
            user.read(scan);             // 사용자 비밀번호와 포인트 입력
            user.addId(this, scan);      // 사용자의 구매 상품 ID 입력, 구매한 상품 추가
            users.add(user);             // 사용자 목록에 추가
        }
    }

    // 메인 메뉴를 출력하고, 사용자의 선택에 따라 기능 실행
    void mainMenu() {
        while (true) {
            System.out.println("(1) 상품출력 (2) 사용자출력  (3) 상품검색   (4) 사용자검색 (0) 종료 => ");
            switch (scan.nextInt()) {
                case 1 -> printAllItems();  // 상품 출력
                case 2 -> printAllUsers();  // 사용자 출력
                case 3 -> searchByItem();   // 상품 검색
                case 4 -> searchByUser();   // 사용자 검색
                case 0 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;  // 프로그램 종료
                }
                default -> System.out.println("잘못된 선택입니다.");
            }
        }
    }

    // 사용자 이름을 키워드로 검색하는 메서드
    void searchByUser() {
        System.out.print("사용자 검색 키워드: ");
        String keyword = scan.next();
        boolean flag = false;

        for (User user : users) {
            if (user.name.contains(keyword)) {  // 이름에 키워드가 포함되어 있으면
                user.print();                   // 사용자 정보 출력
                flag = true;
            }
        }

        if (!flag) {
            System.out.println("사용자를 찾을 수 없습니다.");  // 키워드와 일치하는 사용자가 없으면 메시지 출력
        }
    }

    // 상품을 키워드로 검색하는 메서드
    void searchByItem() {
        System.out.print("상품검색 키워드: ");
        String keyword = scan.next();
        boolean flag = false;

        for (Item item : items) {
            if (item.matchesItem(keyword)) {  // 키워드와 일치하는 상품이 있으면
                item.print();                 // 상품 정보 출력
                flag = true;
            }
        }

        if (!flag) {
            System.out.println("상품을 찾을 수 없습니다.");  // 일치하는 상품이 없으면 메시지 출력
        }
    }

    // 주어진 ID로 상품을 찾는 메서드
    Item findItemById(int id) {
        for (Item item : items) {
            if (item.matchesId(id)) {
                return item;  // ID가 일치하는 상품 반환
            }
        }
        return null;  // 찾지 못하면 null 반환
    }

    // 프로그램의 시작점
    public static void main(String[] args) {
        Store store = new Store();
        store.mymain();
    }
}
