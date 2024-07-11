/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *Viết chương trình đếm số ước và số ước nguyên tố của một số N nhập vào từ bàn phím

 */
public class baii10 {

  public static void main(String[] args) {
        int N, p, s, k, i, t;
        s = k = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so N duong: ");
        N = scanner.nextInt();
        
        int[] a = new int[N + 1];
        
        for (i = 2; i <= N; i++) {
            a[i] = 1;
        }
        
        for (p = 2; p < N; p++) {
            t = N / p;
            for (i = 2; i <= t; i++) {
                a[p * i] = 0;
            }
        }
        
        for (i = 2; i <= N; i++) {
            if (a[i] == 1 && N % i == 0) {
                k++;
            }
        }
        
        p = 0;
        for (i = 1; i <= N; i++) {
            if (N % i == 0) {
                s++;
            }
        }
        
        System.out.printf("Vay so uoc la %d \nSo uoc nguyen to la %d\n", s, k);
        
        scanner.close();
    }
}
