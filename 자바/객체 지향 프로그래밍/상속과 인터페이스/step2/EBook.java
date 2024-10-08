package step2;

import java.util.Scanner;

public class EBook extends Book {
    static String bookType = "전자책";
    String url;
    String format;

    @Override
    void read(Scanner scan) {
        super.read(scan);
        url = scan.next();
        format = scan.next();
    }

    @Override
    void print() {
        super.print();
        System.out.printf("\t%s [%s]\n", url, format);
    }

    String getBookType() {
        return bookType;
    }

    @Override
    boolean matches(String kwd) {
        if (super.matches(kwd)) return true;
        if (url.contains(kwd)) return true;
        if (format.equals(kwd)) return true;
        return false;
    }
}
