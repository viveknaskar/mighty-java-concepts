import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class DateAndTime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        LocalDate localDate = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);
    }
}