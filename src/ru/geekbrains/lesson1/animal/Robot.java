package ru.geekbrains.lesson1.animal;

import ru.geekbrains.lesson1.Participant;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot implements Participant {

    private String name;
    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Robot(String name, int runDistance, int jumpHeight){
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.name = name;
        this.isOnDistance = true;
    }

    public Robot(String name) {
        this.name = name;
        this.isOnDistance = true;
        this.runDistance = 200; // все же робот
        this.jumpHeight = 100;
    }

    @Override
    public boolean isOnDistance() {
        return isOnDistance; // TODO доработать по аналогии с классами животных
    }

    @Override
    public void run(int distance) {
        // TODO доработать по аналогии с классами животных
        if (!isOnDistance()){
            return;
        }
        if (distance>this.runDistance){
            this.isOnDistance = false;
            return;
        }
        System.out.format("Робот %s пробежал кросс длиной %d \n", this.name, distance);
    }

    @Override
    public void jump(int height) {
        // TODO доработать по аналогии с классами животных
        if (!isOnDistance()){
            return;
        }
        if (height>this.jumpHeight){
            this.isOnDistance = false;
            return;
        }
        System.out.format("Робот %s прыгнул на высоту %d \n", this.name, height);
    }

    @Override
    public void swim(int distance) {
        // TODO доработать по аналогии с классами животных
        if (!isOnDistance()){
            return;
        }
        if (distance>this.runDistance){
            this.isOnDistance = false;
            return;
        }
        System.out.format("Робот %s проплыл на расстояние %d \n", this.name, distance);
    }

    @Override
    public void personalInformation() {
        System.out.format("Робот %s, его возраст и цвет не имеют значения, он может прыгнуть на высоту %d" +
                        " и при этом пробежать на расстояние %d \n", this.name,
                this.jumpHeight, this.runDistance);
    }
}
