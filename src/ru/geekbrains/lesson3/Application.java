package ru.geekbrains.lesson3;

import java.util.HashMap;
import java.util.Random;


public class Application{
    public static void main(String[] arg) {
        // Задание №1
        HashMap<String, Integer> listWord = new HashMap<>();
        Random rnd = new Random();
        for (int i=0; i<20; i++) {
            switch (rnd.nextInt(5)) {
                case 0: MyAdd(listWord, "Миша"); break;
                case 1: MyAdd(listWord, "Коля"); break;
                case 2: MyAdd(listWord, "Витя"); break;
                case 3: MyAdd(listWord, "Ваня"); break;
                case 4: MyAdd(listWord, "Агомагомед"); break;
                default: MyAdd(listWord, "Нонейм");
            }
        }

        System.out.println("Список уникальных слов: " + listWord.keySet());
        System.out.println("Число повторений каждого слова: " + listWord);

        // Задание №2
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Фёдоров", "9635421111");
        myPhoneBook.add("Фёдоров", "9635421111");
        myPhoneBook.add("Иванов", "9635422241");
        myPhoneBook.add("Петров", "9635325241");
        myPhoneBook.add("Климов", "9637725241");
        myPhoneBook.add("Фёдоров", "9635425242");
        System.out.println(myPhoneBook.get("Фёдоров"));
    }

    private static void MyAdd(HashMap<String, Integer> arr, String str){
        Integer re = arr.get(str);
        arr.put(str, re == null ? 1 : re+1);
    }
}
