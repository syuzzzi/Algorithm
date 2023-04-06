import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine(); //숫자 입력받기
        int[] arr = new int[n.length()]; //숫자 저장할 배열

        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i) - '0'; //n의 각 자리를 배열에 저장. int로 변환되어 저장됨
        }

        Arrays.sort(arr); //오름차 순으로 정렬

        for (int i = n.length() - 1; i > -1; i--) {
            System.out.print(arr[i]);
        }
    }
}