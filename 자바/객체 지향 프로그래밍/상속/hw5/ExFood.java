package hw5;

import java.util.Scanner;

public class ExFood extends Food {
    int extraCal;
    String extraUnit;

    @Override
    void read(Scanner scan) {
        super.read(scan);
        extraCal = scan.nextInt();
        extraUnit = scan.next();
    }

    @Override
    void printNoLn() {
        System.out.format("%s-%s (%dkcal/%s) %d %s", type, name, cal, unit, extraCal, extraUnit);
    }

    @Override
    void printDetail(int n, String u) {
        // -> 468kcal*200/250g=374kcal
        System.out.format(" -> %dkcal*%d/%d%s=%dkcal", cal, n, extraCal, extraUnit, getKcal(n, u));
    }

    @Override
    int getKcal(int n, String u) {
        return cal * n / extraCal;
    }

    @Override
    void printEat(int n, String u) {
        // 샌드위치 200g(374kcal) - 468kcal/1개(250g)
        System.out.format("%s %d%s(%dkcal)", name, n, u, getKcal(n, u));
        System.out.format(" - %dkcal/%d%s(%d%s)", cal, 1, unit, extraCal, extraUnit);
        printDetail(n, u);
        System.out.println();
    }
}
