/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 Một số gọi là siêu số nguyên tố nếu số lượng các số nguyên tố từ 1 đến X (ngoại trừ X) là
một số nguyên tố. Hãy viết chương trình đếm số lượng các siêu số nguyên tố này trong khoảng
[A,B] cho trước nhập từ bàn phím.
 */
public class baii21 {

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
        int a, b, t = 0;
        System.out.print("Nhap A: ");
        a = sc.nextInt();
        System.out.print("Nhap B: ");
        b = sc.nextInt();

        sieve(b);

        for (int i = a; i <= b; i++) {
            int temp = 0;
            for (int j = 2; j < i; j++) {
                if (s[j] == 0) {
                    temp++;
                }
            }
            if (s[temp] == 0) {
                System.out.println(i);
                t++;
            }
        }
        System.out.println("Co " + t + " so sieu nguyen to");

    }
    
}
