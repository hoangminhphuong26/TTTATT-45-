/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;
//Viết chương trình tìm các số nguyên tố có N chữ số với N nhập từ bàn phím và 2 ≤ N ≤
//10.

import java.util.Scanner;

public class bai2soNT {

    public static void main(String[] args) {
        int n, a, b, p, t, i;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.printf(" Nhap so nt N : ");
            n = sc.nextInt();
        } while (n < 2 || n > 10);
        a = (int) Math.pow(10, n - 1);
        b = (int) Math.pow(10, n) - 1;

        int[] arr = new int[b + 2];
        //dung sang nguyen to
        for (i = a; i <= b; i++) {
            arr[i] = 1;
        }
        for (p = 2; p < b; p++) {
            t = b / p;
            for (i = 2; i <= t; i++) {
                arr[p * i] = 0;
            }
        }

        System.out.printf("So nguyen to co %d chu so la:", n);
        for (i = a; i <= b; i++) {
            if (arr[i] == 1) {
                System.out.printf(i + " ");
            }
        }
    }

}
//input 2
//output 11 13 17  19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
// đã check
