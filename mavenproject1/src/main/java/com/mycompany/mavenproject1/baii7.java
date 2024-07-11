/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *Một số emirp là một số nguyên tố mà khi đảo ngược vị trí các chữ số của nó, ta cũng được
một số nguyên tố. Viết chương trình liệt kê các số emirp nhỏ hơn N với N nhập vào từ bàn phím
 * @author abc
 */
public class baii7 {

    static int[] s;

    static int reverse(int x) {
        long temp = 0;
        long rev = 0;
        while (x != 0) {
            temp = x % 10;
            rev = rev * 10 + temp;
            x = x / 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) rev;
    }

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

    static void solve(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 0 && s[reverse(i)] == 0) {
                count++;
                System.out.println("So emirp thu " + count + " la: " + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap N: ");
        int n = sc.nextInt();
        sieve(n);//sang
        solve(n);
    }
    
}
