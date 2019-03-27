package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

import java.io.PrintStream;

public class Human extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Human(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Human(String name, Color color) {
        super(name, color, 0);
        this.isOnDistance = true;
        this.runDistance = 0;
        this.jumpHeight = 0;
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance; // TODO доработать по аналогии с классом Cat
    }

    @Override
    public void run(int distance) {
        // TODO доработать по аналогии с классом Cat
        if (!isOnDistance()){
            return;
        }
        if (distance>this.runDistance){
            this.isOnDistance = false;
            return;
        }
        System.out.format("Человек %s пробежал кросс длиной %d \n", this.getName(), distance);
    }

    @Override
    public void jump(int height) {
        // TODO доработать по аналогии с классом Cat
        if (!isOnDistance()){
            return;
        }
        if (height>this.jumpHeight){
            this.isOnDistance = false;
            return;
        }
        System.out.format("Человек %s прыгнул на высоту %d \n", this.getName(), height);
    }

    @Override
    public void swim(int distance) {
        // TODO доработать по аналогии с классом Cat
        if (!isOnDistance()){
            return;
        }
        if (distance>this.runDistance){
            this.isOnDistance = false;
            return;
        }
        System.out.format("Человек %s проплыл на расстояние %d \n", this.getName(), distance);
    }

    @Override
    public void voice() {
        // TODO доработать по аналогии с классом Cat
        System.out.println("За Россию!");
    }

    @Override
    public void personalInformation() {
        System.out.format("Человек %s в возрасте %d цвет волос - %s может прыгнуть на высоту %d" +
                        " и при этом пробежать на расстояние %d \n", getName(), getAge(), getColor().getName(),
                this.jumpHeight, this.runDistance);
    }
}
