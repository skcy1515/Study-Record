package step4;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

abstract public class Manager {
    ArrayList<Manageable> mList = new ArrayList<>();

    void search(Scanner scan) {
        String kwd;
        while (true) {
            System.out.print("검색 키워드: ");
            kwd = scan.next();
            if (kwd.equals("end")) break;
            for (Manageable b : mList) {
                if (b.matches(kwd))
                    b.print();
            }
        }
    }

    void printAll() {
        for (Manageable b : mList)
            b.print();
    }

    void readAll(String filename, Factory fac) {
        Scanner filein = openFile(filename);
        Manageable item = null;
        while (filein.hasNext()) {
            item = fac.create(filein);
            item.read(filein);
            mList.add(item);
        }
    }

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패: %s\n", filename);
            throw new RuntimeException(e);
        }
        return filein;
    }
}
