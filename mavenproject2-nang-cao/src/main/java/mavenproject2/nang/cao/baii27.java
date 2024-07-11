/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Scanner;


public class baii27 {

    static int[] S;

    static void Sieve(int n) {
        S = new int[n + 1];
        S[0] = S[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (S[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    S[j] = 1;
                }
            }
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static void solve(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (S[gcd(i, j)] == 0) {
                    System.out.println("(" + i + ", " + j + ")");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Nhap N: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Sieve(n);
        System.out.println("Cac cap so do la: ");
        solve(n);
    }
    
}
