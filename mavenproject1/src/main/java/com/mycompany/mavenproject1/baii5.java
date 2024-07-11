/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *Viết chương trình tính tổng của các số nguyên tố nằm trong khoảng [A, B] với A, B nhập
vào từ bàn phím
 * @author abc
 */
public class baii5 {

    
    static int[] s;

    static void sieve(int n) {
        s = new int[n + 1];
        s[0] = s[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (s[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    s[j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("left: ");
        int left = sc.nextInt();
        System.out.print("right: ");
        int right = sc.nextInt();
        sieve(right);
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (s[i] == 0) {
                result += i;
            }
        }
        System.out.println(result);
    }
    
}
//Eratosthenes
