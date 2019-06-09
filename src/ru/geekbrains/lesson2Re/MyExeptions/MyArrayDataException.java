package ru.geekbrains.lesson2Re.MyExeptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException (String Message, int Row, int Column){
        super("Элемент [" + (Row+1) + "][" + (Column+1) + "] = " + Message + " перевод не удался");
    }
}
