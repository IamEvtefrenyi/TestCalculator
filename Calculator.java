package com.company.Calculator;

import java.util.Scanner;

import static com.company.Calculator.RomanNumber.*;
import static com.company.Calculator.MethodCalculator.*;

public class Calculator {
    static Scanner in = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        try {
            System.out.println("Input: ");
            String str = in.nextLine();
            char[] str1 = new char[9];

            for (int i = 0; i < str.length(); i++) {
                str1[i] = str.charAt(i);

                if (str1[i] == '+') {
                    operation = '+';
                }
                if (str1[i] == '-') {
                    operation = '-';
                }
                if (str1[i] == '*') {
                    operation = '*';
                }
                if (str1[i] == '/') {
                    operation = '/';
                }
            }
            String str1CharToString = String.valueOf(str1);
            String[] elements = str1CharToString.split("[+-/*]");
            String x = elements[0];
            String x1 = x.trim();
            String y = elements[1];
            String y1 = y.trim();

            number1 = romanToNumber(x1);
            number2 = romanToNumber(y1);
            if (number1 < 0 & number2 < 0) {
                result = 0;
            } else {
                result = calculated(number1, number2, operation);
                String resultRoman = convertNumToRoman(result);
                System.out.println("Output \n" + resultRoman);
            }
            number1 = Integer.parseInt(x1);
            number2 = Integer.parseInt(y1);
            if (number1 < 0 || number1 > 10 || number2 < 0 || number2 > 10) {
                System.out.println("число " + number1 + " или " + number2 + " не соответствует диапазону от 1 до 10");
            } else {
                result = calculated(number1, number2, operation);
                System.out.println("Output \n" + result);
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
        } catch (ArithmeticException error) {
            System.out.println("На ноль делить нельзя");
        } catch (NumberFormatException error) {
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
        }
    }
}
