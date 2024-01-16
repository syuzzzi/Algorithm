import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat year = new SimpleDateFormat("yyyy-MM-dd");

        year.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        String time = year.format(date);

        System.out.println(time);
    }
}