package ru.geekbrains.lesson2Re;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainEx {

    enum DayOfWeek{
        Monday(1),
        Tuesday(2),
        Wednesday(3),
        Thursday(4),
        Friday(5),
        Saturday(6),
        Sunday(7);

        private int DayNumber;
        final private static int WorkingHours = 40;

        DayOfWeek(int DayNumber){
            this.DayNumber = DayNumber;
        }

        public static int getWorkingHours(DayOfWeek Day){
            Integer sub = WorkingHours - (Day.DayNumber -1) * 8;
            if(sub<0) return 0;
            return sub;
        }
    }

    public static void main(String[] args) {
        System.out.println(DayOfWeek.getWorkingHours(DayOfWeek.Sunday));
    }
}
