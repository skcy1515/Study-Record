크기를 입력받아 네모, 빈 네모, 이등변 삼각형, 빈 네모에 단어 출력을 하는 함수

```
크기를 입력하세요...8
********
********
********
********
********
********
********
********

********
*      *
*      *
*      *
*      *
*      *
*      *
********

        *
       ***
      *****
     *******
    *********
   ***********
  *************
 ***************

한단어 입력:msg
********
*      *
*      *
* msg  *
*      *
*      *
*      *
********

```

개선할 점: static 쓰지 않기, main 메소드에 코드 줄이고, 함수 더 만들기

개선 코드 아웃라인
```
package hw1A_2024;

import java.util.Scanner;

public class MyMain_1_HW_A {
	Scanner scan = new Scanner(System.in);

	void mymain() {
		int size;
		while (true) {
			System.out.print("크기를 입력하세요...");
			size = scan.nextInt();
			if (size == 0)
				break;
			drawFillBox(size);
			System.out.println();
			drawABox(size);
			System.out.println();
			drawTriangle(size);
			System.out.println();
			challengeA(size);
		}
		System.out.println("안녕히 가세요.");
		System.out.println();
	}

	void drawSolidLine(int size) { ...

	void drawBlankN(int n) {

	void drawBlankLine(int size) { ...

	// step 1
	void drawFillBox(int size) { ...

	// step 3
	void drawABox(int size) { ...

	// step 4
	void drawTriangle(int size) { ...

	// step 5
	void challengeA(int size) { ... // 단어 입력 및 drawMsgBox 호출

	// 메시지 들어가는 한줄, 왼쪽 빈칸, 오른쪽 빈칸 계산
	void drawMsgLine(int size, String msg) { ...

	void drawMsgBox(int size, String msg) { ...
		drawSolidLine(size);
		int spaceTop = (size - 3) / 2;
		...
		drawSolidLine(size);
	}

	public static void main(String args[]) {
		MyMain_1_HW_A my = new MyMain_1_HW_A();
		my.mymain();
	}
}
```
