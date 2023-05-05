package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        char sign;
        String[] storage;
        int secondValue;
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
        if (storage[0].length() > 10 || storage[1].length() > 10) throw new Exception("Строки должны быть длиной не более 10 симоволов");
        if (!storage[0].contains("\"")) throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка");
        if (sign == '/' || sign == '*') {
            if (storage[1].contains("\"")) throw new Exception("Строку можно делить и умножать только на число");
        }
        if (sign == '/' || sign == '*') {
            secondValue = Integer.parseInt(storage[1]);
            if (secondValue > 10 || secondValue < 1) throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
        }
        for (int i = 0; i < storage.length; i++) {
            storage[i] = storage[i].replace("\"", "");
        }
        if (sign == '+') {
            Quotes(storage[0] + storage[1]);
        } else if (sign == '*') {
            int multi = Integer.parseInt(storage[1]);
            String value = storage[0].repeat(multi);
            Quotes(value);
        } else if (sign == '-') {
            int index = storage[0].indexOf(storage[1]);
            if (index == -1) {
                Quotes(storage[0]);
            } else {
                String response = storage[0].substring(0, index);
                response += storage[0].substring(index+storage[1].length());
                Quotes(response);
            }
        } else {
            int newInt = storage[0].length()/Integer.parseInt(storage[1]);
            String response2 = storage[0].substring(0,newInt);
            Quotes(response2);
        }
    }
    static void Quotes(String text) {
        if (text.length() <= 40) {
            System.out.println("\""+text+"\"");
        } else if (text.length() > 40) {
            System.out.println("\""+text.substring(0, 39)+"..." + "\"");
        }
    }
}