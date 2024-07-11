/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Random;
import java.util.Scanner;

/**
 *. Viết chương trình tìm các số nguyên tố từ một mảng sinh ngẫu nhiên có kích thước N,
với N nhập vào từ bàn phím
 * @author abc
 */
public class baii16 {

    /**
     * @param args the command line arguments
     */
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

        // chuyển n-1 về dạng (2^s)*r
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
        System.out.print("Nhap vao so phan tu cua mang: ");
        int n = sc.nextInt();
        // sinh mảng ngẫu nhiên
        long[] arr = new long[n];
        System.out.print("Mang duoc sinh ra la: ");
        for (int i = 0; i < n; i++) {
            arr[i] = (new Random().nextInt(1000 - 3) + 2);
            System.out.print(arr[i] + " ");
        }

        System.out.printf("\nSo nguyen to trong mang la: ");
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (MillerRabin(arr[i], 2)) {
                System.out.print(arr[i] + " ");
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("(Khong co)");
        }
    }
    
}
