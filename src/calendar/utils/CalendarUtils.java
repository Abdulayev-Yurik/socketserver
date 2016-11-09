package calendar.utils;

import java.time.LocalDate;

/**
 * Created by employee on 11/2/16.
 */
public class CalendarUtils {

    static final String TYPICAL_STRING_FORMAT = "%5s";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String WEB_VIEW = "web";
    public static final String CONSOLE_VIEW = "console";
    protected static final int DAYS_IN_WEEK = 7;

    public static String toAnotherMonthColor(String value, String type){
        if (type.equals(WEB_VIEW))
            return "<td class=\"anotherMonthColor\">" + value + "</td>";
        else if (type.equals(CONSOLE_VIEW))
            return ANSI_YELLOW + value + ANSI_RESET;
        else
            return value;
    }

    protected String toThisDayColor(String value, String type) {
        if (type.equals(WEB_VIEW))
            return "<td class=\"currentDay\">" + value + "</td>";
        else if (type.equals(CONSOLE_VIEW))
            return ANSI_CYAN + value + ANSI_RESET;
        return value;
    }

    protected String toWeekendColor(String value, String type) {
        if (type.equals(WEB_VIEW))
            return "<td class=\"weekend\">" + value + "</td>";
        else if (type.equals(CONSOLE_VIEW))
            return ANSI_RED + value + ANSI_RESET;
        return value;
    }

    protected String getFormattedDay(String numberDay) {
        return String.format(CalendarUtils.TYPICAL_STRING_FORMAT, numberDay);
    }

    protected int getBeforeValue(LocalDate localDate, int customFirstDay) {
        return localDate.getDayOfWeek().getValue() == customFirstDay ?
                7 - localDate.minusDays(1).getDayOfMonth() : getBeforeValue(localDate.plusDays(1), customFirstDay);
    }

}
