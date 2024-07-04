import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] B = new int[N];

        int j = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] < X) {
                B[j] = A[i];
                j++;
            }
        }

        for (int i = 0; i < j; i++) {
            System.out.println(B[i]);
        }
    }
}