package step4;

import java.util.ArrayList;
import java.util.Scanner;

public class ABook extends Book {
    static String bookType = "부록책";
    ArrayList<String> appendix = new ArrayList<>();

    @Override
    public void read(Scanner scan) {
        super.read(scan);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++)
            appendix.add(scan.next());
    }

    @Override
     public void print() {
        super.print();
        System.out.print("\t");
        for (String s : appendix)
            System.out.printf("%s ", s);
        System.out.println();
    }

    String getBookType() {
        return bookType;
    }

    @Override
    public boolean matches(String kwd) {
        if (super.matches(kwd)) return true;
        for (String s : appendix){
            if (s.contains(kwd)) return true;
        }
        return false;
    }
}
