package ru.asteises.year_2022;

public class BinarySearchTest1 {

    public static void main(String[] args) {
        int[] arrayAsc = {1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32};

        int[] arrayDesc = {32, 30, 24, 22, 20, 13, 12,  8,  5,  2, 1};

        System.out.println("Индекс искомого элемента: " + searchBinaryAscending(arrayAsc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinaryDescending(arrayDesc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(arrayAsc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(arrayDesc, 30));
    }

    private static int searchBinary(int[] array, int elem) {
        // возвращает 1, если массив отсортирован по возрастанию, и -1, если по убыванию
        int sort = getSortRecursive(array, 0, 0);
        if(sort > 0){
            return  searchBinaryAscending(array, elem);
        } else if (sort < 0){
            return searchBinaryDescending(array, elem);
        } else {
            return -1;
        }
    }

    private static int getSortRecursive(int[] array, int sort, int next) {
        return 0;
    }

    private static int searchBinaryAscending(int[] array, int num) {
        return 0;
    }

    private static int searchBinaryDescending(int[] array, int num) {
        return 0;
    }
}
