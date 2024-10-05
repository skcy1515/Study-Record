package book;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    Scanner scan = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<>();

    void mymain() {
        readAllBooks();
        printAllBooks();
    }

    void readAllBooks() {
        Scanner filein = openFile("book2.txt");
        Book b = null;
        int n;
        while (filein.hasNext()) {
            n = filein.nextInt();
            b = switch (n) {
                case 1 -> new Book();
                case 2 -> new EBook();
                default -> b;
            };
            b.read(filein);
            bookList.add(b);
        }
        filein.close();
    }

    void printAllBooks() {
        for (Book b : bookList) {
            b.print();
        }
    }

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("File open failed : " + filename);
            throw new RuntimeException(e);
        }
        return filein;
    }


    public static void main(String[] args) {
        BookStore store = new BookStore();
        store.mymain();
    }
}
