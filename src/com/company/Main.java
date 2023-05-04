package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        char sign;
        String[] storage;
        if (expression.contains(" + ")) {
            storage = expression.split(" \\+ ");
            sign = '+';
        } else if (expression.contains(" - ")) {
            storage = expression.split(" - ");
            sign = '-';
        } else if (expression.contains(" / ")) {
            storage = expression.split(" / ");
            sign = '/';
        } else if (expression.contains(" * ")) {
            storage = expression.split(" \\* ");
            sign = '*';
        } else {
            throw new Exception("Неверный знак");
        }
        if (sign == '/' || sign == '*') {
            if (storage[1].contains("\"")) throw new Exception("Строку можно делить и умножать только на число");
        }
        for (int i = 0; i < storage.length; i++) {
            storage[i] = storage[i].replace("\"", "");
        }
        if (sign == '+') {
            System.out.println("\""+storage[0] + storage[1]+"\"");
        } else if (sign == '*') {
            int multi = Integer.parseInt(storage[1]);
            String value = storage[0].repeat(multi);
            System.out.println("\""+value+"\"");
        } else if (sign == '-') {
            int index = storage[0].indexOf(storage[1]);
            if (index == -1) {
                System.out.println("\""+storage[0]+"\"");
            } else {
                String response = storage[0].substring(0, index);
                response += storage[0].substring(index+storage[1].length());
                System.out.println("\""+response+"\"");
            }
        } else {
            int newInt = storage[0].length()/Integer.parseInt(storage[1]);
            String response2 = storage[0].substring(0,newInt);
            System.out.println("\""+response2+"\"");
        }
    }
}