package ru.asteises.year_2022;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortTest {

    public static void main(String[] args) {
        int[] array = {29, 28, 44, 4, 10, 83, 11};

        int[] sorted = mergeSortDescending(array);
        if(sorted[0] < sorted[1]) {
            throw new RuntimeException("not sorted");
        } else {
            System.out.println("Массив отсортирован: " + Arrays.stream(sorted).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
        }
    }

    private static int[] mergeSortDescending(int[] array) {
        if(array.length <= 1) { // базовый случай рекурсии
            return array;
        }

        // заводим массив для результата сортировки
        int[] ret = new int[array.length];

        // запускаем сортировку рекурсивно на левой половине
        int[] left = mergeSortDescending(Arrays.copyOfRange(array, 0, array.length / 2));

        // запускаем сортировку рекурсивно на правой половине
        int[] right = mergeSortDescending(Arrays.copyOfRange(array, array.length / 2, array.length));

        int leftIdx = 0;
        int rightIdx = 0;
        int retIdx= 0;

        // сливаем результаты
        while (leftIdx < left.length && rightIdx < right.length){
            /* Выбираем, из какого массива забрать минимальный элемент,
            тем самым сортируем значения в итоговом массиве. */
            if(left[leftIdx] >= right[rightIdx]){
                ret[retIdx] = left[leftIdx];
                leftIdx++;
            } else {
                ret[retIdx] = right[rightIdx];
                rightIdx++;
            }
            retIdx++;
        }

        /* Если один массив закончился раньше, чем второй, то
        переносим оставшиеся элементы второго массива в результирующий,
        иначе просто не заходим в цикл. */
        while (leftIdx < left.length){
            ret[retIdx] = left[leftIdx];
            leftIdx++;
            retIdx++;
        }
        // то же для правой части
        while (rightIdx < right.length){
            ret[retIdx] = right[rightIdx];
            rightIdx++;
            retIdx++;
        }

        return ret;
    }
}
