package calendar.printing;

import calendar.console.ConsoleCalendar;
import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Created by yurik on 05.11.16.
 */
public class PrintCustomCalendar {

    public PrintCustomCalendar(){
        innitCustomCalendar();
    }

    private void innitCustomCalendar() {
        Calendar calendar = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type calendar : 1 - Console, 2 - Web Calendar");
        int type = scanner.nextInt();
        System.out.println("Enter year :");
        int year = scanner.nextInt();
        System.out.println("Enter number month :");
        int month = scanner.nextInt();
        System.out.println("Enter day of month :");
        int day = scanner.nextInt();
        System.out.println("Enter custom start day of week : ");
        int customStartDay = getFirsDayOfWeek(scanner.nextInt());
        System.out.println("Enter weekends: 1,2,3");
        List<DayOfWeek> weekends = getWeekends(new Scanner(System.in).nextLine());
        switch (type) {
            case 1:
                calendar = new ConsoleCalendar(LocalDate.of(year, month, day),
                        DayOfWeek.of(customStartDay), weekends);
                break;
            case 2:
                calendar = new WebCalendar(LocalDate.of(year, month, day),
                        DayOfWeek.of(customStartDay), weekends);
                break;
        }

        if (calendar != null) calendar.print();
    }


    private static List<DayOfWeek> getWeekends(String weekends) {
        List<DayOfWeek> listWeekends = new ArrayList<>();
        if (weekends.isEmpty()) {
            return Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        }
        int numberDay = 0;
        for (String s : weekends.split(",")) {
            numberDay = parseInt(s.trim());
            if ( numberDay >= DayOfWeek.MONDAY.getValue() && numberDay <= DayOfWeek.SUNDAY.getValue())
            listWeekends.add(DayOfWeek.of(numberDay));
        }
        return listWeekends;
    }

    private static int getFirsDayOfWeek(int day) {
        return day > 0 && day <= 7 ? day : DayOfWeek.MONDAY.getValue();
    }
}
