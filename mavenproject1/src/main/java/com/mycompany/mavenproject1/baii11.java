/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *Viết chương trình tính tổng của các số nguyên tố nhỏ hơn hoặc bằng N với N được nhập
từ bàn phím
 * @author abc
 */
public class baii11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap n: ");
        int n = sc.nextInt();
        sieve(n);
        solve(n);
    }
    
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

    static void solve(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (s[i] == 0) {
                result += i;
            }
        }
        System.out.println(result);
    }
}
