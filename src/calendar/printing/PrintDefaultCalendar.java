package calendar.printing;

import calendar.console.ConsoleCalendar;
import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;

import java.util.Scanner;

/**
 * Created by yurik on 01.09.16.
 */
public class PrintDefaultCalendar {

    public PrintDefaultCalendar(){
        Calendar calendar = null;
        System.out.println("Enter print mode, 1-Console, 2-WEB page");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                calendar = new ConsoleCalendar();
                break;
            case 2:
                calendar = new WebCalendar();
                break;
        }
        if (calendar != null){
            calendar.print();
        }
    }

}