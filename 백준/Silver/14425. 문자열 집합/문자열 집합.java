import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //집합 s를 이루는 문자열 개수
        int m = sc.nextInt(); //입력으로 주어지는 문자열 개수
        int count = 0; //포함되어 있는 개수
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) { //n개의 문자열을 집합 s 배열에 저장
            map.put(sc.next(), 0); //String만 중요해서 Integer 값은 아무거나 함
        }

        for (int i = 0; i < m; i++) {
            String str = sc.next();

            if (map.get(str) != null) //map에 str과 동일한 문자열이 있으면 count 증가
                count++;
        }

        System.out.println(count);
    }
}