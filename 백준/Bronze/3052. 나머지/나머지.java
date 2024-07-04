import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        int[] arr2 = new int[10];

        for (int i = 0; i < 10; i++) {
            arr2[i] = arr[i] % 42;
        }

        int count = 0;

        for (int i = 0; i < 10; i++) {
            int a = 0;
            for (int j = i + 1; j < 10; j++) {
                if (arr2[i] == arr2[j]) {
                    a++;
                }
            }
            if (a == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}