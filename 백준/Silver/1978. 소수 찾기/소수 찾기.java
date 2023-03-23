import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //소수의 개수 입력받기
        int[] arr = new int[n]; //개수 길이의 정수 배열 생성

        for (int i = 0; i < n; i++) { //배열에 숫자 저장
            arr[i] = sc.nextInt();
        }

        int primeNumCount = 0; //소수 개수 세는 변수

        for (int i = 0; i < n; i++) {
            int count = 0;

            if (arr[i] == 1) {
                continue;
            }

            for (int j = 2; j < arr[i]; j++) {
                if (arr[i] % j == 0) { //나머지가 0이라면
                    count++;
                }
            }

            if (count == 0) {
                primeNumCount++;
            }
        }

        System.out.println(primeNumCount);
    }
}