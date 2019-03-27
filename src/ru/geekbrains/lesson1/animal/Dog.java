package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Dog extends Animal{

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Dog(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Dog(String name, Color color) {
        super(name, color, 0);
        this.isOnDistance = true;
        this.runDistance = 0;
        this.jumpHeight = 0;
    }

    @Override
    public void voice() {
        System.out.println("Гав");
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
        System.out.format("Собака %s пробежала кросс длиной %d \n", this.getName(), distance);
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
        System.out.format("Собака %s прыгнула на высоту %d \n", this.getName(), height);
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
        System.out.format("Собака %s проплыла на расстояние %d \n", this.getName(), distance);
    }

    @Override
    public void personalInformation() {
        System.out.format("Собака %s в возрасте %d цвет - %s может прыгнуть на высоту %d" +
                        " и при этом пробежать на расстояние %d \n", getName(), getAge(), getColor().getName(),
                this.jumpHeight, this.runDistance);
    }
}
