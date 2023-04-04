import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //수의 개수 입력받기
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); //배열에 저장
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}