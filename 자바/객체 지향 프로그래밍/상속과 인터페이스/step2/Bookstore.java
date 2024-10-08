package step2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Bookstore {
    Scanner scan = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<>();

    void mymain() {
        readAllBooks();
        printAllBooks();
        search();
    }

    private void search() {
        String kwd;
        while (true) {
            System.out.print("검색 키워드: ");
            kwd = scan.next();
            if (kwd.equals("end")) break;
            for (Book b : bookList) {
                if (b.matches(kwd))
                    b.print();
            }
        }
    }

    private void printAllBooks() {
        for (Book b : bookList)
            b.print();
    }

    private void readAllBooks() {
        Scanner filein = openFile("book3.txt");
        while (filein.hasNext()) {
            int type = filein.nextInt();

            Book b = switch (type) {
                case 1 -> new Book();
                case 2 -> new EBook();
                default -> new ABook();
            };
            b.read(filein);
            bookList.add(b);
        }
    }

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패: %s\n", filename);
            throw new RuntimeException(e);
        }
        return filein;
    }

    public static void main(String[] args) {
        Bookstore store = new Bookstore();
        store.mymain();
    }
}
