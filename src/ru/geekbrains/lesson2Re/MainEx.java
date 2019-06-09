package ru.geekbrains.lesson2Re;

import ru.geekbrains.lesson2Re.MyExeptions.MyArrayDataException;
import ru.geekbrains.lesson2Re.MyExeptions.MyArraySizeException;

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

    private static int getSumValuesArrayString(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int i, j, sum;
        i = j = sum = 0;
        try {
            if (arr.length != 4) throw new MyArraySizeException("Число строк массива не равно 4");
            for (i = 0; i < arr.length; i++) {
                for (j = 0; j < arr[i].length; j++) {
                    if (arr[i].length != 4) throw new MyArraySizeException("Число элементов в строке " +(i+1) + " не равно 4");
                    sum += Integer.valueOf(arr[i][j]);
                }
            }
        }catch(NumberFormatException ex){
            throw new MyArrayDataException(ex.getMessage(), i, j);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(DayOfWeek.getWorkingHours(DayOfWeek.Sunday));

        String[][] Arr =    {{"1", "2", "1", "2"},
                            {"2", "1", "0", "1"},
                            {"3", "1", "2", "1"},
                            {"4", "9", "2", "1"}};
        try{
            System.out.println(getSumValuesArrayString(Arr));
        }catch(MyArraySizeException ex){
            System.out.println(ex.getMessage());
        }catch(MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }
    }
}
