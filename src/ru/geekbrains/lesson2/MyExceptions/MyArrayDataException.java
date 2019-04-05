package ru.geekbrains.lesson2.MyExceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(int row, int column) {
        super("Привести типы не удалось. \n" + "Ошибка произошла в строке-" + row + "; столбце-" + column);
    }
}
