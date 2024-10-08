package step4;

import java.util.Scanner;

public class Bookstore extends Manager implements Factory {
    Scanner scan = new Scanner(System.in);

    void mymain() {
        readAll("book4.txt", this);
        printAll();
        search(scan);
    }

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

    public static void main(String[] args) {
        Bookstore store = new Bookstore();
        store.mymain();
    }
}
