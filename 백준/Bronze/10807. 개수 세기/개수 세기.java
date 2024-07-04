import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int[] arr = new int[num1];

        for (int i = 0; i < num1; i++) {
            arr[i] = sc.nextInt();
        }

        int v = sc.nextInt();

        int count = 0;

        for (int i = 0; i < num1; i++) {
            if (v == arr[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}