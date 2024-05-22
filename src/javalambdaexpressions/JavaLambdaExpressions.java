/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalambdaexpressions;

import java.util.Scanner;

/**
 *
 * @author Slime nightmare
 */
public class JavaLambdaExpressions {

    /**
     * @param args the command line arguments
     */
    //Ham check dieu kien le
    public static boolean isOdd(int num) {
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }

    //Ham check so nguyen to
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else if (num == 2) {
            return true;
        } else {
            for (int i = 3; i < Math.sqrt(num)+1; i += 2) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //Ham check so nguyen to xuoi nguoc
    public static boolean isPalindrome(int num) {
        if (!isPrime(num)) {
            return false;
        } else {
            String strNum = "" + num;
            char[] digits = strNum.toCharArray();
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != digits[(digits.length - i - 1)]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean[] findResult(int[] listOption, int[] listNumber) {
        boolean[] listResult = new boolean[listOption.length];
        for (int i = 0; i < listOption.length; i++) {
            int num = listNumber[i];
            switch (listOption[i]) {
                case 1:
                    if (isOdd(num)) {
                        listResult[i] = true;
                    } else {
                        listResult[i] = false;
                    }
                    break;
                case 2:
                    if (isPrime(num)) {
                        listResult[i] = true;
                    } else {
                        listResult[i] = false;
                    }
                    break;
                case 3:
                    if (isPalindrome(num)) {
                        listResult[i] = true;
                    } else {
                        listResult[i] = false;
                    }
                    break;

            }
        }
        return listResult;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] listOption = new int[length];
        int[] listNumber = new int[length];
        for (int i = 0; i < 2 * length; i++) {
            int numberInput = sc.nextInt();
            if (i % 2 == 0) {
                listOption[i / 2] = numberInput;
            } else {
                listNumber[(i - 1) / 2] = numberInput;
            }
        }
        boolean[] result = findResult(listOption, listNumber);

        for (int i = 0; i < result.length; i++) {
            switch (listOption[i]) {
                case 1:
                    if (result[i]) {
                        System.out.println("ODD");
                    } else {
                        System.out.println("EVEN");
                    }
                    break;
                case 2:
                    if (result[i]) {
                        System.out.println("PRIME");
                    } else {
                        System.out.println("COMPOSITE");
                    }
                    break;
                case 3:
                    if (result[i]) {
                        System.out.println("PALINDROME");
                    } else {
                        System.out.println("NOT PALINDROME");
                    }
                    break;
            }
        }
    }

}
