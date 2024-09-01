import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        }

        int[] earned = new int[n + 1];
        
        // 역순으로 최대 수익 계산
        for (int i = n - 1; i >= 0; i--) {
            int duration = list.get(i)[0];
            int profit = list.get(i)[1];

            // 일을 선택할 수 없는 경우
            if (i + duration > n) {
                earned[i] = earned[i + 1];
            } else {
                // 일을 선택했을 때의 수익과 일을 선택하지 않았을 때의 수익 중 더 큰 값
                earned[i] = Math.max(profit + earned[i + duration], earned[i + 1]);
            }
        }

        System.out.println(earned[0]);
    }
}
