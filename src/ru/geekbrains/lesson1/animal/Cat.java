package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;
import ru.geekbrains.lesson1.enums.Color;

public class Cat extends Animal{

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Cat(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    // в старом конструкторе мы дали возможность не определять ряд полей,
    // кажется, при обращении к ним в дальнейшем, можем получить ошибку
    public Cat(String name, Color color) {
        super(name, color, 0);
        this.isOnDistance = true;
        this.runDistance = 0;
        this.jumpHeight = 0;
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Кошка %s пробежала кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            return;
        }
        System.out.println(String.format("Собака %s пругнула на высоту %d \n", getName(), height));
    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println("Кошка не умеет плавать");
        // throw new UnsupportedOperationException("Кошка не умеет плавать");
    }

    @Override
    public void personalInformation() {
        System.out.format("Кот %s в возрасте %d цвет - %s может прыгнуть на высоту %d" +
                " и при этом пробежать на расстояние %d \n", getName(), getAge(), getColor().getName(),
                this.jumpHeight, this.runDistance);
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }
}
