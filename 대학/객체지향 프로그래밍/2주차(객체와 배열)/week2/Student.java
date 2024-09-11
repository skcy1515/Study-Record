package week2;

import java.util.Scanner;

public class Student {
    String id;
    String name;
    int year;
    int score[] = new int[3];

    static int[] scores = {90, 80, 70, 60, 0};
    static char[] grades = {'A', 'B', 'C', 'D', 'F'};

    void read(Scanner scan) {
        id = scan.next();
        name = scan.next();
        year = scan.nextInt();
        for (int k = 0; k < 3; k++) {
            score[k] = scan.nextInt();
        }
    }

    char calculate(int score) {
        for (int i = 0; i < scores.length; i++) {
            if (score >= scores[i]) {
                return grades[i];
            }
        }
        return 'F';
    }

    void print() {
        System.out.printf("%s\t%s %d학년 ", id, name, year);
        for (int k = 0; k < 3; k++) {
            char grade = calculate(score[k]); // 각 점수에 대한 학점 계산
            System.out.printf("%d (%c) ", score[k], grade);
        }
        System.out.println("");
    }
}
