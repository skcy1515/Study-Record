package step4;

import java.util.Scanner;

public class Tissue implements Manageable{
    String name;
    int nSheets;
    int price;

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        nSheets = scan.nextInt();
        price = scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("%s %d장 %d원\n", name, nSheets, price);
    }

    @Override
    public boolean matches(String kwd) {
        if (name.contains(kwd)) return true;
        if ((""+nSheets).equals(kwd)) return true;
        return false;
    }
}
