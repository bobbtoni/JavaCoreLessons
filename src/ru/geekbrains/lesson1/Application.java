package ru.geekbrains.lesson1;

import ru.geekbrains.lesson1.animal.*;
import ru.geekbrains.lesson1.course.Course;
import ru.geekbrains.lesson1.course.Cross;
import ru.geekbrains.lesson1.course.Wall;
import ru.geekbrains.lesson1.course.Water;
import ru.geekbrains.lesson1.enums.Color;

/**
 * Класс для запуска приложения - симулятор кросса
 */
public class Application {

    public static void main(String[] args) {
        Team team1 = new Team(
                new Cat("Барсик", Color.BLACK, 1, 100, 5),
                new Dog("Шарик", Color.YELLOW, 1, 80, 7),
                new Human ("Иван", Color.WHITE, 56, 200, 15),
                new Robot ("P1001-25/45")
                // TODO здесь должны быть участники всех видов (Cat, Dog, Human, Robot)
        );

        Team team2 = new Team(
                new Cat("Мурзик", Color.BROWN, 2, 30, 2),
                new Dog("Бим", Color.RED, 3, 50, 2),
                new Human ("Колян", Color.WHITE, 23, 54, 4),
                new Robot ("P1002-25/45", 700, 40)
                // TODO здесь должны быть участники всех видов (Cat, Dog, Human, Robot)
        );

        Course course = new Course(
                new Cross(50),
                new Wall(10),
                new Cross(90),
                new Water(5)
        );

        System.out.println("Состав наших команд: ");
        System.out.println("Команда №1: "); team1.allInfo();
        System.out.println("Команда №2: "); team2.allInfo();
        course.doIt(team1);
        course.doIt(team2);
        System.out.println("После полосы припятствий остались на ногах:: ");
        System.out.println("Команда №1: "); team1.memberInfo();
        System.out.println("Команда №2: "); team2.memberInfo();
    }
}
