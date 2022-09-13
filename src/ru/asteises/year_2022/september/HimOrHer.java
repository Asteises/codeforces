package ru.asteises.year_2022.september;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HimOrHer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        whoIsWho(s);
    }

    public static void whoIsWho(String string) {
        Set<Character> characters = new HashSet<>();
        int result = 0;
        for (Character c: string.toCharArray()) {
            if (characters.add(c)) {
                result++;
            }
        }
        if (result % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
