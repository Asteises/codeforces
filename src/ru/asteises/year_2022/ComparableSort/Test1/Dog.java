package ru.asteises.year_2022.ComparableSort.Test1;

public class Dog implements Comparable<Dog> {
    private final String nickname;

    public Dog(String nickname){
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public int compareTo(Dog o) {
        return 1;
    }

    /* Вам предстоит реализовать метод compareTo и, возможно, equals —
    подумайте, какая между ними связь. */
}


