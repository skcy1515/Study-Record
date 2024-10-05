package book;

import java.util.Scanner;

public class EBook extends Book {
    String url;
    String format;

    @Override
    void read(Scanner scan) {
        super.read(scan);
        // 2 자료구조 생능출판 1001 2003 천인국 공용해 하상호 0  15000
        // http://www.sangreung.co.kr/computer/chun/datastructure PDF
        url = scan.next();
        format = scan.next();
    }

    @Override
    void print() {
        super.print();
        System.out.printf("\t%s [%s]\n", url, format);
    }
}
