/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *Viết chương trình Hai số nguyên tố sinh đôi là hai số nguyên tố hơn kém nhau 2 đơn vị.
Tìm hai số nguyên tố sinh đôi nhỏ hơn hoặc bằng N, với N được nhập vào từ bàn phím.
 *
 */
public class baiii15 {

    static int[] s;
    static int[] a;

    static void sieve(int n) {
        s = new int[n + 1];
        a = new int[n];
        s[0] = s[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (s[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    s[j] = 1;
                }
            }
        }
        int j = 0;
        for (int i = 2; i <= n; i++) {
            if (s[i] == 0) {
                a[j++] = i;
            }
        }
    }

    static void solve() {
        System.out.println("Cac cap so nguyen to sinh doi la : ");
        int i = 0;
        while (a[i + 1] != 0) {
            if (s[a[i]] == 0 && s[a[i + 1]] == 0 && a[i + 1] - a[i] == 2) {
                System.out.println("(" + a[i] + ", " + a[i + 1] + ")");
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap N: ");
        int n = sc.nextInt();
        sieve(n);
        solve();
    }
    
}
