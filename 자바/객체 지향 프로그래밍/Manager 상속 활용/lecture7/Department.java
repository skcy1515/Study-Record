package lecture7;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

import java.util.Scanner;

public class Department extends Manager implements Factory {
    Scanner scan = new Scanner(System.in);
    static Manager lectureMgr = new Manager();

    void run() {
        lectureMgr.readAll("lecture.txt", new LectureFactory());
        lectureMgr.printAll();
        readAll("student.txt", this);
        printAll();
        search(scan);
    }

    class LectureFactory implements Factory {
        public Manageable create(Scanner scan) {
            return new Lecture();
        }
    }

    static public Lecture findLecture(String code) {
        return (Lecture) lectureMgr.find(code);
    }

    @Override
    public Manageable create(Scanner scan) {
        return new Student();
    }

    public static void main(String args[]) {
        Department my = new Department();
        my.run();
    }
}