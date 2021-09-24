package com.sunanda;
import java.util.Scanner;

/**
 * author:-Sunanda
 * Date:- 22/09/2021
 */

public class ReverseNumber {
    public static void main(String[] args)
    {
        int number, reverse = 0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number.");
        number=sc.nextInt();
        while(number != 0)
        {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number/10;
        }
        System.out.println("Reverse number is: " + reverse);
    }
}
