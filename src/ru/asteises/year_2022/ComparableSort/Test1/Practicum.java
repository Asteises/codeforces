package ru.asteises.year_2022.ComparableSort.Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practicum {

    public static void main(String[] args) {
        List<Dog> unsortedDogs = Stream.of(
                        "Дружок", "Пушок", "Тузик", "Ромео",
                        "Белка", "Стрелка", "Бобик", "Афоня",
                        "Волчок")
                .map(Dog::new)
                .collect(Collectors.toList());

        // найдите Белку
        Dog dog = new Dog("Белка");
        String result = search(unsortedDogs, dog)
                .map(d -> "А вот и собака по кличке " + d + " нашлась")
                .orElseGet(() -> "Нет собаки по кличке " + dog + " :(");

        System.out.println(result);
    }

    private static <T extends Comparable<T>> Optional<T> search(List<T> unsortedList, T searchObject) {
        List<T> sortedList = new ArrayList<>(); // искать легче по упорядоченному списку — вам поможет алгоритм сортировки
        int idx = -1; // найдите Белку, учтите, что idx может быть -1, если ничего не нашлось.
        Dog dog = new Dog("Дружок");
        return (Optional<T>) Optional.of(dog);
    }

    // методы сортировки и поиска
}
