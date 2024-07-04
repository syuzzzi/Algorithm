import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        for (int i = 0; i < C; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            float sum = 0;

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }

            float avg = sum / N;
            float count = 0;

            for (int j = 0; j < N; j++) {
                if (arr[j] > avg) {
                    count++;
                }
            }

            System.out.printf("%.3f%%\n", count / N * 100);
        }
    }
}