package ru.geekbrains.lesson1;

/**
 * Класс - комманда участников соревнований
 */
public class Team {

    private Participant[] participants;

    // здесь используется конструктор с переменным числом параметров
    public Team(Participant... participants) {
        // внутри метода переменное число параметров интерпретируется как массив
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void allInfo(){
        for (Participant participant : participants){
            participant.personalInformation();
        }
    }

    public void memberInfo(){
        for (Participant participant : participants){
            if (participant.isOnDistance()) {
                participant.personalInformation();
            }
        }
    }
}
