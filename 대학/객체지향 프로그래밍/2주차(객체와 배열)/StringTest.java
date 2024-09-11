import java.util.Scanner;

public class StringTest {
    String[] names;

    void mymain() {
        Scanner scanner = new Scanner(System.in);
        int size;
        size = scanner.nextInt();
        names = new String[size];

        int maxLength = 0;
        String maxLengthStr = "";

        // 입력을 받으면서 최대 길이 문자열을 찾음
        for (int i=0; i<size; i++){
            names[i] = scanner.next();

            // 최대 길이 문자열 업데이트
            if (names[i].length() > maxLength) {
                maxLengthStr = names[i];
                maxLength = names[i].length();
            }
        }

        // 각 문자열과 길이 출력
        for (int i=0; i<size; i++){
            System.out.printf("%s\t길이:%d\n", names[i], names[i].length());
        }
        System.out.printf("제일 긴 스트링: %s", maxLengthStr);

        // Scanner 닫기
        scanner.close();
    }

    public static void main(String[] args) {
        StringTest my = new StringTest();
        my.mymain();
    }
}
