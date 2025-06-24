package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Problem4 {
    public static void main(String[] args) {
        try {
            int count = getCountFromSources(args);

            if (count == -1) {
                printUsage();
                return;
            }

            printHelloWorld(count);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Некорректный формат числа");
            e.printStackTrace();
            printUsage();
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла:");
            e.printStackTrace();
            printUsage();
        }
    }

    private static int getCountFromSources(String[] args) throws NumberFormatException, IOException {
        // 1. Проверяем аргументы командной строки (JSCHOOl1_COUNT=XXX)
        for (String arg : args) {
            if (arg.startsWith("JSCHOOl1_COUNT=")) {
                return Integer.parseInt(arg.split("=")[1]);
            }
        }

        // 2. Проверяем системную переменную (-DJSCHOOl1_COUNT=XXX)
        String sysProp = System.getProperty("JSCHOOl1_COUNT");
        if (sysProp != null) {
            return Integer.parseInt(sysProp);
        }

        // 3. Проверяем переменную окружения
        String envVar = System.getenv("JSCHOOl1_COUNT");
        if (envVar != null) {
            return Integer.parseInt(envVar);
        }

        // 4. Проверяем properties-файл, если указан в переменной окружения
        String propsFile = System.getenv("JSCHOOL1_PROPERTIES_FILE");
        if (propsFile != null) {
            try (FileInputStream fis = new FileInputStream(propsFile)) {
                Properties props = new Properties();
                props.load(fis);
                String countStr = props.getProperty("JSCHOOl1_COUNT");
                if (countStr != null) {
                    return Integer.parseInt(countStr);
                }
            }
        }

        return -1;
    }

    private static void printHelloWorld(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Hello, World!");
        }
    }

    private static void printUsage() {
        System.out.println("Способы задания количества повторений:");
        System.out.println("1. Через аргумент командной строки: JSCHOOl1_COUNT=XXX");
        System.out.println("2. Через системную переменную: -DJSCHOOl1_COUNT=XXX");
        System.out.println("3. Через переменную окружения: JSCHOOl1_COUNT=XXX");
        System.out.println("4. Через properties-файл: JSCHOOL1_PROPERTIES_FILE=путь/к/файлу.properties");
        System.out.println("Где XXX - целое число, сколько раз вывести сообщение");
    }
}