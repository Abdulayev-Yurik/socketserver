package calendar;

import calendar.printing.PrintCustomCalendar;
import calendar.printing.PrintDefaultCalendar;

import java.util.Scanner;

/**
 * Created by yurik on 07.09.16.
 */
public class Run {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Use default calendar ? 1 - Yes , 2 - No :");
        int typeCalendar = scanner.nextInt();
        if (typeCalendar == 1){
            new PrintDefaultCalendar();
        }else if(typeCalendar == 2){
            new PrintCustomCalendar();
        }else {
            System.out.println("incorrect value");
            run();
        }
    }
}