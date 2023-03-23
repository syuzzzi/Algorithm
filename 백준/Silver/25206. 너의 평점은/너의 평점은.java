import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0; //개수를 세어주는 변수 생성. 0으로 초기화
        double[] credit = new double[20]; //학점을 저장할 배열
        String[] grade_E = new String[20]; //영어등급(A+, B0, ... )을 저장할 배열
        double[] grade = new double[20]; //숫자등급을 저장할 배열

        for (int i = 0; i < 20; i++) { //20줄에 걸쳐 입력받으므로 20번 반복
            sc.next(); //과목명 입력받기
            credit[count] = sc.nextDouble(); //학점 입력받기
            grade_E[count] = sc.next(); //등급 입력받기

            if (Objects.equals(grade_E[count], "A+")) {
                grade[count] = 4.5;
                count++;
            }
            else if (Objects.equals(grade_E[count], "A0")) {
                grade[count] = 4.0;
                count++;
            }
            else if (Objects.equals(grade_E[count], "B+")) {
                grade[count] = 3.5;
                count++;
            }
            else if (Objects.equals(grade_E[count], "B0")) {
                grade[count] = 3.0;
                count++;
            }
            else if (Objects.equals(grade_E[count], "C+")) {
                grade[count] = 2.5;
                count++;
            }
            else if (Objects.equals(grade_E[count], "C0")) {
                grade[count] = 2.0;
                count++;
            }
            else if (Objects.equals(grade_E[count], "D+")) {
                grade[count] = 1.5;
                count++;
            }
            else if (Objects.equals(grade_E[count], "D0")) {
                grade[count] = 1.0;
                count++;
            }
            else if (Objects.equals(grade_E[count], "F")) {
                grade[count] = 0.0;
                count++;
            }
            else if (Objects.equals(grade_E[count], "P")){
                credit[count] = 0.0;
                grade_E[count] = null;
            }
        }

        double finalScore = 0; //과목평점을 저장할 변수

        for (int i = 0; i < count; i++) {
            finalScore += credit[i] * grade[i];
        }

        double sumCredit = 0;

        for (int i = 0; i < count; i++) {
            sumCredit += credit[i];
        }
        
        System.out.println(finalScore / sumCredit);
    }
}