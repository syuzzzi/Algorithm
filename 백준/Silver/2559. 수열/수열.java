import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //온도 측정 전체 날짜 수
        int k = sc.nextInt(); //연속 날짜
        int[] arr = new int[n]; //전체 날짜 온도 배열
        int[] arr_sum = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); //온도를 배열에 넣어줌
        }

        for (int i = 0; i < n - k + 1; i++) {
            int sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += arr[j];
                arr_sum[i] = sum;
            }
        }

        int max = arr_sum[0];

        for (int i = 0; i < n - k + 1; i++) {
            if (max < arr_sum[i])
                max = arr_sum[i];
        }

        System.out.println(max);
    }
}