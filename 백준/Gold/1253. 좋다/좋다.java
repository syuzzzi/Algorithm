import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //n개의 수 입력받기
        int[] arr = new int[n]; //n개의 수를 저장할 배열 생성
        int num = 0; //좋은 수가 몇개인지 저장하는 변수 생성, 초기화

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); //배열에 저장
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int j = 0; //배열 제일 앞의 원소를 가리키는 인덱스
            int k = n - 1; //배열 맨 뒤의 원소를 가리키는 인덱스

            while (j < k) {
                if (arr[j] + arr[k] == arr[i]) { //j번째 k번째 합이 i번째와 같고
                    if (j != i && k != i) { //서로 다른 인덱스면
                        num++; //좋은 수의 개수를 늘려줌
                        break;
                    }
                    else if (j == i) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
                else if (arr[j] + arr[k] < arr[i]) { //j번째 k번째 합이 i보다 작으면
                    j++;
                }
                else {
                    k--;
                }
            }
        }

        System.out.println(num);
    }
}