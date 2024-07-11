/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 * Viết chương trình in ra các số nguyên dương x nằm trong khoảng [m,l] sao cho
 * giá trị của biểu thức 𝐴𝑥 2 + 𝐵𝑥 + 𝐶 là một số nguyên tố. Với A,B,C, m,l
 * là các số nguyên nhập từ bàn phím (m<l)
 * @
 *thuật toán Miller-Rabin
 * author abc
 */
import java.util.Random;
import java.util.Scanner;

public class baii19 {

    static long binhPhuongCoLap(long a, long k, long n) {
        long b = 1;
        if (k == 0) {
            return b;
        }
        long A = a;

        long[] nhiPhan = new long[10000];
        int index = 0;
        while (k > 0) {
            nhiPhan[index++] = k % 2;
            k /= 2;
        }

        if (nhiPhan[0] == 1) {
            b = a;
        }
        for (int i = 1; i < index; i++) {
            A = (A * A) % n;
            if (nhiPhan[i] == 1) {
                b = (A * b) % n;
            }
        }
        return b;
    }

    static boolean MillerRabin(long n, int t) {
        // check trước khi vào thuật toán
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        }

        // chuyển n về dạng (2^s)*r
        int s = 0;
        long m = n - 1, r;
        while (m % 2 == 0) {
            m /= 2;
            s++;
        }
        r = m;

        for (int i = 1; i <= t; i++) {
            // random số ngẫu nhiên a, 2 <= a <= n-2
            long a = (new Random().nextLong(n - 3)) + 2;
            long y = binhPhuongCoLap(a, r, n);

            // nếu trường hợp (a^r)mod n chưa đúng tiếp tục kiểm tra trường hợp  a^((2^j)*r) = -1 mod n
            if (y != 1 && y != n - 1) {
                int j = 1;
                while (j <= s - 1 && y != n - 1) {
                    y = (y * y) % n;
                    if (y == 1) {
                        return false;
                    }
                    j++;
                }
                if (y != n - 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("A*x^2+B*x+C");
        System.out.print("Nhap A: ");
        int a = sc.nextInt();
        System.out.print("Nhap B: ");
        int b = sc.nextInt();
        System.out.print("Nhap C: ");
        int c = sc.nextInt();
        System.out.print("Nhap m: ");
        long m = sc.nextInt();
        System.out.print("Nhap l: ");
        long l = sc.nextInt();

        int z = 0;
        for (long x = m; x <= l; x++) {
            long sum = a * x * x + b * x + c;
            if (MillerRabin(sum, 2)) {
                System.out.println("So x thoa man la: " + x);
                z = 1;
            }
        }
        if (z == 0) {
            System.out.println("Khong co x thoa man");
        }
    }

}
