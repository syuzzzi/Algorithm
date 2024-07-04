import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] base = new int[100][100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                base[i][j] = 0;
            }
        }

        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b + 10; k++) {
                    base[j][k] = 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (base[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}