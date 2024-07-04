import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[30];

        for (int i = 0; i < 30; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < 28; i++) {
            int a = sc.nextInt();

            for (int j = 0; j < 30; j++) {
                if (a == j + 1) {
                    arr[j] = a;
                }
            }
        }

        int arr2[] = new int[2];
        int a = 0;

        for (int i = 0; i < 30; i++) {
            if (arr[i] == 0) {
                arr2[a] = i + 1;
                a++;
            }
        }

        if (arr2[0] > arr2[1]) {
            a = arr2[0];
            arr2[0] = arr2[1];
            arr2[1] = a;
        }

        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
    }
}