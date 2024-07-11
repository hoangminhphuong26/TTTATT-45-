/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *Viết chương trình in ra các cặp số (A,B) nằm trong khoảng (M,N) sao cho ước số chung
lớn nhất của A và B có giá trị là một số D cho trước. Với M,N,D nhập vào từ bàn phím. (0<M,N,
D < 1000).

 * @author abc
 */
public class baii20 {

   static long UCLN(long a, long b) {
        long temp;
        while (b > 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m, n, d;
        do {
            System.out.print("Nhap m: ");
            m = sc.nextInt();
            System.out.print("Nhap n: ");
            n = sc.nextInt();
            System.out.print("Nhap d: ");
            d = sc.nextInt();
        } while (m < 1 || n < 1 || d < 1 || n >= 1000 || m >= 1000 || d >= 1000 || n < m);

        for (long i = m + 1; i < n; i++) {
            for (long j = i + 1; j < n; j++) {
                if (d == UCLN(i, j)) {
                    System.out.println("cap so do la: (" + i + "," + j + ")");
                }
            }
        }
    }
    
}
