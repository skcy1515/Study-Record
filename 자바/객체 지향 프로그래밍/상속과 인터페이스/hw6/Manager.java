package hw6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class Manager {
    ArrayList<Manageable> mList = new ArrayList<>();

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }
        return filein;
    }

    void readAll(String filename, Factory fac) {
        Scanner filein = openFile(filename);
        Manageable m = null;
        while (filein.hasNext()) {
            m = fac.create();
            m.read(filein);
            mList.add(m);
        }
        filein.close();
    }

    void printAll() {
        for (Manageable m : mList) {
            m.print();
        }
    }

    void search(Scanner scan) {
        String name = null;
        while (true) {
            System.out.print("키워드:");
            name = scan.next();
            if (name.equals("end"))
                break;
            for (Manageable m : mList) {
                if (m.matches(name))
                    m.print();
            }
        }
    }
}
