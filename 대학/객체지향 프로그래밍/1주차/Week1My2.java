import java.util.Scanner;

public class Week1My2 {
    Scanner scanner = new Scanner(System.in);

    // 길이만큼 '*'을 한 줄 출력하는 함수
    void drawSolidLine(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // 길이만큼 빈 줄을 출력하는 함수
    void drawBlankLine(int size, int paddingCount) {
        for (int i = 0; i < paddingCount; i++) {
            System.out.print("*");
            drawBlankN(size - 2);
            System.out.println("*");
        }
    }

    // 빈 칸 n개를 출력하는 함수
    void drawBlankN(int paddingCount) {
        for (int i = 0; i < paddingCount; i++) {
            System.out.print(" ");
        }
    }

    // 가운데 단어가 있는 빈 네모 출력하는 함수
    void drawMsgLine(int size, String word) {
        int wordLength = word.length();
        int topPadding = (size - 3) / 2;
        int bottomPadding = size - 3 - topPadding;
        int leftPadding = (size - 2 - wordLength) / 2;
        int rightPadding = size - 2 - wordLength - leftPadding;

        drawSolidLine(size);
        drawBlankLine(size, topPadding);

        System.out.print("*");
        drawBlankN(leftPadding);
        System.out.print(word);
        drawBlankN(rightPadding);
        System.out.println("*");

        drawBlankLine(size, bottomPadding);
        drawSolidLine(size);
    }

    // 네모 그리기 함수
    void drawFillBox(int size) {
        for (int i = 0; i < size; i++) {
            drawSolidLine(size);
        }
        System.out.println("");
    }

    // 빈 네모 그리기 함수
    void drawABox(int size) {
        drawSolidLine(size);  // 상단 테두리 출력
        drawBlankLine(size, size - 2);  // 중간 빈 줄 출력
        drawSolidLine(size);  // 하단 테두리 출력
        System.out.println("");
    }

    // 이등변 삼각형 그리기 함수
    void drawTriangle(int size) {
        for (int j = 0; j < size; j++) {
            drawBlankN(size - j - 1);  // 왼쪽 여백 출력
            for (int k = 0; k < 2 * j + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("");
    }

    // 메인 함수
    void mymain() {
        while (true) {
            System.out.print("크기를 입력하세요...");
            int size = scanner.nextInt();
            scanner.nextLine();  // 버퍼 비우기

            if (size == 0) {
                System.out.println("안녕히 가세요.");
                scanner.close();
                break;
            }

            // 네모 그리기
            drawFillBox(size);

            // 빈 네모 그리기
            drawABox(size);

            // 이등변 삼각형 그리기
            drawTriangle(size);

            // 빈 네모에 단어 출력하기
            System.out.print("출력할 단어를 입력하세요...");
            String word = scanner.nextLine();
            drawMsgLine(size, word);
        }
    }

    public static void main(String[] args) {
        Week1My2 my = new Week1My2();
        my.mymain();
    }
}


