package calendar.console;

import calendar.interfaces.Calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yurik on 05.11.16.
 */
public class ConsoleCalendar extends Calendar {

    public ConsoleCalendar() {
        this(LocalDate.now());
    }

    public ConsoleCalendar(LocalDate thisDate) {
        this(thisDate, DayOfWeek.MONDAY);
    }

    public ConsoleCalendar(LocalDate thisDate, DayOfWeek startWeek) {
        this(thisDate, startWeek, Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
    }

    public ConsoleCalendar(LocalDate thisDate, DayOfWeek startWeek, List<DayOfWeek> weekend) {
        innit(thisDate, startWeek, weekend);
    }

    public void print() {
        generateView();
    }

    public void generateView() {
        StringBuilder view = new StringBuilder();
        view.append("\t ").append(getCurrentMonthHeader()).append("\n");
        view.append(getWeekNames());
        view.append("\n");
        view.append(getMonthValues());
        System.out.println(view.toString());
    }

    public String getMonthValues() {
        return new StringBuilder()
                .append(getPreviousMonthDays(CONSOLE_VIEW))
                .append(getCurrentMonthValues(CONSOLE_VIEW))
                .append(getNextMonthDays(CONSOLE_VIEW))
                .toString();
    }

    public String getWeekNames() {
        StringBuilder builder = new StringBuilder();
        for (DayOfWeek dayOfWeek : getWeekdays(getStartWeekValue())) {
            String dayName = getFormattedDay(getDayValue(dayOfWeek));
            builder.append(isWeekend(dayOfWeek) ?
                    toWeekendColor(dayName, CONSOLE_VIEW) : dayName);
        }
        return builder.toString();
    }
}
