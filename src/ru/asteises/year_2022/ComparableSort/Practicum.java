package ru.asteises.year_2022.ComparableSort;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Practicum {

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Гречка", 91.6),
                new Product("Рис", 89.4),
                new Product("Булгур", 124.)
        );

        // попробуйте использовать метод max с другими типами данных
        Product mostExpensive = max(products);

        System.out.printf("%s самый дорогой продукт среди перечисленных: %s",
                mostExpensive, products);
    }

    public static <T extends Comparable<T>> T max(Collection<T> objects) {
        if(objects.isEmpty()) {
            return null;
        }

        Iterator<T> iterator = objects.iterator();
        T max = iterator.next();

        while (iterator.hasNext()) {
            T element = iterator.next();
            if(max.compareTo(element) < 0) {
                max = element;
            }
        }
        return max;
    }
}
