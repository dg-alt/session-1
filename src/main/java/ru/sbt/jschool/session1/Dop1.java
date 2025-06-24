package ru.sbt.jschool.session1;

public class Dop1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Пожалуйста, укажите двоичное число в аргументах командной строки");
            return;
        }

        String binary = args[0];
        try {
            long decimal = binaryToDec(binary);
            System.out.println("Десятичное представление: " + decimal);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат двоичного числа");
        }
    }

    public static long binaryToDec(String binary) {
        return Long.parseLong(binary, 2);
    }
}
