package ru.geekbrains.lesson2;

import ru.geekbrains.lesson2.MyExceptions.MyArrayDataException;
import ru.geekbrains.lesson2.MyExceptions.MyArraySizeException;

import java.time.Clock;
import java.util.Scanner;

public class Applcation {

    public static String[] removeElem(String[] arr, int index){
        String[] tArr = new String[arr.length-1];
        for (int i = 0; i < index; i++){
            tArr[i] = arr[i];
        }
        for (int i = index; i < arr.length-1; i++){
            tArr[i] = arr[i+1];
        }
        return tArr;
    }

    public static void FillArrayConsole(String[][] userArray) throws MyArraySizeException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Начните ввод массива (для завершения ввода введите end c новой строки):");

            int i = 0;
            String[] elem;
            Boolean isStop = false;
            while (true) {
                System.out.print("" + (i+1) + " строка: " );
                elem = scanner.nextLine().split(" ");
                if (elem.length>0 & elem[0].equals("end")) { // наш выход из цикла
                    break;
                }
                for (int j = 0; j < elem.length; j++) {
                    if (elem[j].isEmpty()) {elem = removeElem(elem, j--); continue;} // будем игнорировать слипшиеся пробелы
                    userArray[i][j] = elem[j];
                }
                if (elem.length < userArray[i].length) throw new MyArraySizeException("В строке не хватает элекментов");
                i++;
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new MyArraySizeException("Массив не влезает");
        }

    }

    public static long CalcSumArray(String[][] userArray) throws MyArrayDataException{
        int i = 0, j=0;
        try {
            long Result = 0;
            for (i = 0; i < userArray.length; i++) {
                for (j = 0; j < userArray[i].length; j++) {
                    Result += Integer.valueOf(userArray[i][j]);
                }
            }
            return Result;
        }catch (NumberFormatException ex){
            throw new MyArrayDataException(i+1, j+1);
        }
    }

    public static void main (String[] args){
        try{
            String[][] str = new String[4][4];
            FillArrayConsole(str);
            System.out.println("Сумма элекментов массива = " + CalcSumArray(str));

        }catch(MyArraySizeException | MyArrayDataException ex){
            System.out.format("%s", ex);
        }
    }

}
