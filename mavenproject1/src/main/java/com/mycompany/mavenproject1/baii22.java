/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Với một số nguyên dương N thoả mãn 0<N<10000, đặt:
F ( N ) = N nếu N là một số nguyên tố
F ( N ) = 0 nếu là hợp số
Cho L và R nhập vào từ bàn phím, với mọi cặp i , j trong khoảng [ L , R ] hãy viết chương trình
in ra màn hình giá trị tổng của F ( i ) * F ( j ) với j > i. 
 */
public class baii22 {

    static long binhPhuongCoLap(long a, long x, long n) {
        long b = 1;
        if (x == 0) {
            return b;
        }
        long A = a;
        int j = 0;

        long[] nhiPhan = new long[10000];
        while (x > 0) {
            nhiPhan[j++] = x % 2;
            x = x / 2;
        }
        if (nhiPhan[0] == 1) {
            b = a;
        }

        for (int i = 1; i < j; i++) {
            A = (int) (Math.pow(A, 2) % n);
            if (nhiPhan[i] == 1) {
                b = ((A * b) % n);
            }
        }
        return b;
    }

    public static boolean Fermat(long n, int t) {
        if (n < 2 || n % 2 == 0) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 1; i <= t; i++) {
            long a = (new Random().nextLong(n - 3)) + 2;
            long r = binhPhuongCoLap(a, n - 1, n);
            if (r != 1) {
                return false;
            }
        }
        return true;
    }

    static long F(long n) {
        return Fermat(n, 5) ? n : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l, r;
        do {
            System.out.print("Nhap L: ");
            l = sc.nextLong();
            System.out.print("Nhap R: ");
            r = sc.nextLong();
        } while (l > r);

        long s = 0;
        for (long i = l; i <= r; i++) {
            for (long j = i + 1; j <= r; j++) {
                s += F(i) * F(j);
            }
        }

        System.out.println("Tong la: " + s);
    }
    
}
