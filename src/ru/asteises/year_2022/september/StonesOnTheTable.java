package ru.asteises.year_2022.september;

import java.util.Scanner;

public class StonesOnTheTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        deleteStones(s2);
    }

    public static void deleteStones(String string) {
        char[] characters = string.toCharArray();
        int result = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            if (characters[i] == characters[i + 1]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
