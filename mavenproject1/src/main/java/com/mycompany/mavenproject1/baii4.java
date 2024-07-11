/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;
//Viết chương trình đếm số số nguyên tố nằm trong khoảng [A,B] với A, B nhập vào từ bàn

import java.util.Scanner;


public class baii4 {

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
// thuật toán Sàng Eratosthenes
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("left: ");
        int left = sc.nextInt();
        System.out.print("right: ");
        int right = sc.nextInt();
        sieve(right);
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (s[i] == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("");
        System.out.println(count);
    }

}
