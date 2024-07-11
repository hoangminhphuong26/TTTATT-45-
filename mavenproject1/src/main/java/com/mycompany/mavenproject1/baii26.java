/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *Một số được gọi là số mạnh mẽ khi nó đồng thời vừa chia hết cho số nguyên tố và chia
hết cho bình phương của số nguyên tố đó. Tìm số mạnh mẽ nhỏ hơn số N cho trước (N < 10000
 * @author abc
 */
public class baii26 {

     static int count;
    static int[] S, primes;

    static void Sieve(int n) {
        S = new int[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (S[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    S[j] = 1;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (S[i] == 0) {
                primes[count++] = i;
            }
        }
    }

    static void solve(int n) {
        for (int i = 4; i < n; i++) {
            for (int j = 0; j < count; j++) {
                if (i % primes[j] == 0 && i % (primes[j] * primes[j]) == 0) {
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        S = new int[n + 1];
        primes = new int[n + 1];
        Sieve(n);
        System.out.println("Cac so thao man la: ");
        solve(n);
    }
    
}
