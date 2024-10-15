package mgr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	ArrayList<Manageable> mList = new ArrayList<>();

	public Manageable find(String name) {
		for (Manageable p : mList) {
			if (p.matches(name))
				return p;
		}
		return null;
	}

	public void readAll(String filename, Factory fac) {
		Scanner filein = openFile(filename);;
		while (filein.hasNext()) {
			Manageable m = fac.create(filein);
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}

	public Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("파일 입력 오류");
			System.exit(0);
		}
		return filein;
	}

	public void printAll() {
		for (Manageable p : mList)
			p.print();
	}

	public void search(Scanner scan) {
		String kwd = null;
		while (true) {
			System.out.print("검색키워드:");
			kwd = scan.next();
			if (kwd.contentEquals("end"))
				break;
			for (Manageable m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}
}