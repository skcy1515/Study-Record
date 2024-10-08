package step4;

import java.util.Scanner;

public class Pen implements Manageable{
    String name;
    float mmThick;
    int price;

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        mmThick = scan.nextFloat();
        price = scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("%s %.1fmm %d원\n", name, mmThick, price);
    }

    @Override
    public boolean matches(String kwd) {
        if (name.contains(kwd)) return true;
        if ((""+mmThick).equals(kwd)) return true;
        return false;
    }
}
