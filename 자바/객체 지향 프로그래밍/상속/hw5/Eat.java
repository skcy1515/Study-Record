package hw5;

import java.util.ArrayList;
import java.util.Scanner;

public class Eat {
    int day, month;
    String eatType;
    int totalCal = 0;
    ArrayList<EatItem> eatList = new ArrayList<>();

    void read(Scanner scan) {
        // 10 1 아침 5
        month = scan.nextInt();
        day = scan.nextInt();
        eatType = scan.next();
        int cc = scan.nextInt();

        EatItem ei = null;
        for (int i = 0; i < cc; i++) {
            ei = new EatItem();
            ei.read(scan);
            eatList.add(ei);
            totalCal += ei.getKcal();
        }
    }

    void print() {
        System.out.printf("%d/%d %s ", month, day, eatType);
        System.out.printf("총칼로리: %dkcal\n", totalCal);
        for (EatItem ei : eatList) {
            System.out.print("  ");
            ei.print();
        }
        System.out.println();
    }

    class EatItem {
        Food food;
        int num;
        String unit;

        void read(Scanner scan) {
            // 샌드위치 200 g
            String name;
            name = scan.next();
            food = CaloryMain.findFood(name);
            if (food == null) {
                System.out.println("푸드 널 - " + name);
            }
            num = scan.nextInt();
            unit = scan.next();
        }

        int getKcal() {
            return food.getKcal(num, unit);
        }

        void print() {
            food.printEat(num, unit);
        }
    }
}