package book;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    // 자료구조 생능출판 1001 2003 천인국 공용해 하상호 0 15000
    String name;
    String pub;
    String isbn;
    int year;
    int price;
    ArrayList<String> authors = new ArrayList<>();

    void read(Scanner scan) {
        name = scan.next();
        pub = scan.next();
        isbn = scan.next();
        year = scan.nextInt();
        String token;
        while (true) {
            token = scan.next();
            if (token.equals("0")) {
                break;
            }
            authors.add(token);
        }
        price = scan.nextInt();
    }

    void print() {
        // 자료구조 (생능출판/1001/2003년) [15000원] 저자:천인국 공용해 하상호
        System.out.printf("%s (%s/%s/%d년) [%d] 저자:", name, pub, isbn, year, price);
        for (String t : authors) {
            System.out.printf("%s ", t);
        }
        System.out.println("");
    }

}
