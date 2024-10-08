package hw6;

import java.util.Scanner;

public class Department extends Manager implements Factory {
    Scanner scan = new Scanner(System.in);

    void run() {
        readAll("students-hw6.txt", this);
        printAll();
        search(scan);
    }

    @Override
    public Manageable create() {
        return new Student();
    }

    public static void main(String args[]) {
        Department my = new Department();
        my.run();
    }
}