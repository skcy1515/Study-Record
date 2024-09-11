package week2;

import java.util.Scanner;

public class Department {
    Scanner scan = new Scanner(System.in);

    void mymain() {
        Student stList[];
        System.out.print("학생수: ");
        int n = scan.nextInt();
        stList = new Student[n];

        for (int i = 0; i < n; i++) {
            stList[i] = new Student();
            stList[i].read(scan);
        }

        for (Student st : stList) {
            st.print();
        }
    }

    public static void main(String[] args) {
        Department my = new Department();
        my.mymain();
    }
}
