package ru.asteises.year_2022;

/**
 * Чтобы узнать индекс середины массива, воспользуемся формулой: int mid = low  + ((high - low) / 2);
 *
 * Проверим, равен ли центральный элемент искомому. Если равен, вернём индекс:
 * if (array[mid] == elem) {
 *     return mid;
 * }
 *
 * Если искомый элемент меньше центрального, рекурсивно ищем элемент в промежутке [low, mid):
 * else if(elem < array[mid]){
 *     return searchBinaryRecursive(array, elem, low, mid);
 * }
 *
 * Если центральный элемент меньше искомого, ищем в правой половине [mid, high).
 * Элемент mid можно не включать в интервал, ведь он уже проверен. Поэтому поиск запустим на промежутке [mid + 1, high):
 * else {
 *     return searchBinaryRecursive(array, elem, mid + 1, high);
 * }
 *
 * На каждом шаге диапазон поиска сужается. Правая граница сдвигается влево либо левая — вправо.
 * При реализации обязательно нужно удостовериться, что границы действительно уменьшаются при любом наборе параметров,
 * иначе рекурсия может уйти в бесконечный цикл:
 * в нашем случае всегда mid < high, поэтому [low, mid) меньше по длине, чем [low, high);
 *
 * кроме того, low < mid + 1 (хотя mid может оказаться равным low),
 * поэтому [mid + 1, high) меньше по длине, чем [low, high).
 *
 * В какой-то момент левая граница может стать равной правой. Такой полуоткрытый интервал не содержит элементов.
 * Можно сделать вывод, что искомого элемента в массиве нет, и вернуть -1. Это будет базовый случай рекурсии.
 */

public class BinarySearchReqursion {

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32};
        System.out.println("Индекс искомого элемента: " + searchBinary(array, 30));
    }

    private static int searchBinary(int[] array, int elem) {
        // изначально мы запускаем двоичный поиск на всей длине массива
        return searchBinaryRecursive(array, elem, 0, array.length - 1);
    }

    private static int searchBinaryRecursive(int[] array, int elem, int low, int high) {
        if(high <= low) { // промежуток пуст
            return -1;
        }
        // промежуток не пуст
        int mid = low  + ((high - low) / 2);
        if (array[mid] == elem) { // центральный элемент — искомый
            return mid;
        } else if(elem < array[mid]){ // искомый элемент меньше центрального — значит, следует искать в левой половине
            return searchBinaryRecursive(array, elem, low, mid);
        } else { // иначе следует искать в правой половине
            return searchBinaryRecursive(array, elem, mid + 1, high);
        }
    }
}
