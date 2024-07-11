/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

//Viết chương trình tìm bốn số nguyên tố liên tiếp, sao cho tổng của chúng là số nguyên tố
import java.util.Scanner;

//nhỏ hơn hoặc bằng N (với N được nhập vào từ bàn phím
public class baii12 {

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

    static void solve(int n) {
        int sum = 0, i = 0;
        while (sum <= n && a[i + 3] != 0) {
            sum = a[i] + a[i + 1] + a[i + 2] + a[i + 3];
            if (sum <= n && s[sum] == 0) {
                System.out.println("4 so nguyen to thoa man: " + a[i] + " " + a[i + 1] + " " + a[i + 2] + " " + a[i + 3]);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap gia tri cua N: ");
        int n = sc.nextInt();
        sieve(n);
        solve(n);
    }
}
