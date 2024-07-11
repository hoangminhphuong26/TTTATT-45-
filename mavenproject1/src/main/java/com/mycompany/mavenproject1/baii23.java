/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Random;
import java.util.Scanner;

/**
 *Viết chương trình in ra màn hình YES trong trường hợp tổng của các số nguyên tố trong
khoảng [A, B] là cũng là một số nguyên tố và NO nếu ngược lại. Với A,B là hai số được nhập vào
từ bàn phím
 * @author abc
 */
public class baii23 {
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

    public static boolean fermat(int n, int t) {
        int r, a;
        if (n < 2 || n % 2 == 0) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 1; i <= t; i++) {
            //chọn ngẫu nhiên a trong khoảng 2<=a<=n-2
            a = (new Random().nextInt(n - 3)) + 2;
            r = Binhphuongcolap(a, n - 1, n);
            if (r != 1) {
                return false;
            }
            a++;
        }
        return true;
    }

    public static int Binhphuongcolap(int a, int x, int n) {
        int b = 1;
        if (x == 0) {
            return b;
        }
        int A = a;
        int j = 0;

        int[] nhiPhan = new int[10000];
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap A: ");
        int a = sc.nextInt();
        System.out.print("Nhap B: ");
        int b = sc.nextInt();

        sieve(b);

        int result = 0;
        for (int i = a; i <= b; i++) {
            if (s[i] == 0) {
                result += i;
            }
        }
        System.out.println("Tong la: " + result);
        if (fermat(result, 5)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
}
