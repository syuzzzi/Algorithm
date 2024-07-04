import java.util.Scanner;

public class Main {
    public static int[] stack = new int[100000]; //스택 생성
    public static int topIndex = -1; //제일 위의 원소의 인덱스를 알려주는 변수 생성 -1로 초기화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(); //반복 횟수 입력받기

        for (int i = 0; i < k; i++) {
            int n = sc.nextInt(); //수 입력받기

            if (n > 0) {
                topIndex++; //스택 인덱스 1 늘려주고
                stack[topIndex] = n; //n을 스택에 저장
            } else if (n == 0) {
                stack[topIndex] = 0; //제일 위의 원소를 0으로 초기화
                topIndex--; //인덱스 1 감소
            }
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += stack[i]; //스택에 남아있는 원소들을 sum에 더해줌
        }

        System.out.println(sum); //sum 출력
    }
}