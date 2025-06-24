package ru.sbt.jschool.session1;

public class Dop2 {
    public static void main(String[] args) {
        // Проверяем, что передано ровно 2 аргумента
        if (args.length != 2) {
            System.out.println("Использование: java Dop2 <двоичное_число1> <двоичное_число2>");
            System.out.println("Пример: java Dop2 1010 1101");
            return;
        }

        String b1 = args[0];
        String b2 = args[1];

        // Проверяем, что строки содержат только 0 и 1
        if (!isValidBinary(b1) || !isValidBinary(b2)) {
            System.out.println("Ошибка: Входные строки должны содержать только 0 и 1");
            return;
        }

        String sum = sumOfBinary(b1, b2);
        System.out.println("Сумма в двоичном виде: " + sum);
    }

    // Метод для сложения двоичных чисел
    public static String sumOfBinary(String b1, String b2) {
        long num1 = Long.parseLong(b1, 2);
        long num2 = Long.parseLong(b2, 2);
        return Long.toBinaryString(num1 + num2);
    }

    // Проверка, что строка состоит только из 0 и 1
    private static boolean isValidBinary(String s) {
        return s.matches("[01]+");
    }
}
