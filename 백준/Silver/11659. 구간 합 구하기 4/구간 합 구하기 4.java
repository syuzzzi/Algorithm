import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n + 1]; //부분합 저장 배열. index 0은 0
        arr[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i-1] + sc.nextInt(); //부분합에 입력받은 수를 더해주며 배열을 채워감
        }

        for (int k = 0; k < m; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            System.out.println(arr[j] - arr[i-1]);
        }
    }
}