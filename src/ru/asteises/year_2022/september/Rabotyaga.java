package ru.asteises.year_2022.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rabotyaga {

    public static final String STOP = "стоп!"; // остановить выполнение
    public static final String LEFT = "левее!"; // перешагнуть команду слева
    public static final String WALK = "шагай!"; // начать выполнение следующей команды
    public static final String RIGHT = "правее!"; // перешагнуть команду справа
    public static final String TURN = "обратно!"; // вернуться к предыдущей команде
    public static final String DIGG = "копай!"; // копать и перейти на следующую команду

    public static final List<String> MASTER_CHIEF_COMMANDS = Arrays.asList(
            WALK, WALK, WALK,
            DIGG, // новый тип команды для рекурсивного робота "Работяга 2.1"
            DIGG, WALK, DIGG, WALK, DIGG, WALK, DIGG, STOP);

    public static final List<List<Character>> LETTER_LIST_LIST = new ArrayList<>(Arrays.asList(
            Arrays.asList('ы', 'т', 'о', 'б', 'а', 'Р'),
            Arrays.asList('й', 'ы', 'т', 'а', 'ч', 'о', 'п', 'е', 'н'),
            Arrays.asList('.', 'й', 'а', 'р', 'к'),
            Arrays.asList('а', 'д', 'е', 'б', 'о', ' ', 'о', 'Д'),
            Arrays.asList('.', 'о', 'к', 'е', 'л', 'а', 'д')));

    public static void main(String[] args) {
        try {
            doMyCommand(0);
            System.out.println("Всё исполнено в лучшем виде!");
        } catch (StackOverflowError err) {
            System.out.println("Робот зациклился, задание провалено!");
        }
    }

    private static void doMyCommand(int cmdIdx) {
        doMyCommandNow(-1, cmdIdx);
    }

    private static void doMyCommandNow(int prevCmdIdx, int cmdIdx) {
        String nextCommand = MASTER_CHIEF_COMMANDS.get(cmdIdx);
        System.out.println("Выполняю команду: " + nextCommand);
        switch (nextCommand) {
            case STOP:
                return;
            case WALK:
                doMyCommandNow(cmdIdx, cmdIdx + 1);
                break;
            case DIGG:
                StringBuilder word = new StringBuilder();
                doDiggLetter(word, LETTER_LIST_LIST.get(0), 0);
                LETTER_LIST_LIST.remove(0);
                doMyCommandNow(cmdIdx, cmdIdx + 1);
                break;
            case LEFT:
                doMyCommandNow(cmdIdx, cmdIdx - 2);
                break;
            case RIGHT:
                doMyCommandNow(cmdIdx, cmdIdx + 2);
                break;
            default:
                throw new RuntimeException("Нет такой команды!");
        }
    }

    private static void doDiggLetter(StringBuilder word, List<Character> characters, int index) {
        for (int i = index; i < characters.size(); i++) {
            word.append(characters.get(i));
        }
        word.reverse();
        System.out.println(word);
    }
}
