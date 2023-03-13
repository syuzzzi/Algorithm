import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //수열의 크기
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); //정렬 시켜준다

        int x = sc.nextInt();
        int count = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                count++;
            }
            
            if (sum <= x) {
                start++;
            }
            else {
                end--;
            }
        }

        System.out.println(count);
    }
}