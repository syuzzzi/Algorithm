import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0; // 소수 합 저장하는 변수
        int min = Integer.MAX_VALUE; // 주어지는 수들은 10000이하이므로 최소값을 큰 값으로 설정

        for (int i = m; i <= n; i++) { // n부터 m까지 수가 소수인지 체크
            boolean isPrime = true; // 소수 판별 결과 저장 변수

            for (int j = 2; j <= (int)Math.sqrt(i); j++) { // 2부터 i-1까지 나눠보며 소수 판별
                if (i % j == 0) { // 나머지가 0이면 소수가 아니라는 뜻.
                    isPrime = false;
                    break;
                }
            }

            if (isPrime && i != 1) { // 1은 소수가 아니므로 제외
                sum += i; // sum에 더해줌

                if (min > i) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
