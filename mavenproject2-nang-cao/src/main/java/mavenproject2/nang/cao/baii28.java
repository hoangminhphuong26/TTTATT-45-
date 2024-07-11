/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Scanner;

/**
 *
 *Viết chương trình tìm các số Carmichael (là các số giả nguyên tố n thoả mãn điều kiện là
hợp số và thoả mãn 𝑏
𝑛−1 ≡ 1 (𝑚𝑜𝑑 𝑛) với mọi số nguyên dương b nguyên tố cùng nhau với n)
nhỏ hơn một số N cho trước nhập vào từ bàn phím (với điều kiện 0 ≤ 𝑁 ≤ 10000.
 */
public class baii28 {

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

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static boolean solve(int n) {
        if (S[n] == 0) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (binhPhuongCoLap(i, n - 1, n) != 1 && gcd(n, i) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap N: ");
        int n = sc.nextInt();
        Sieve(n);
        for (int i = 2; i < n; i++) {
            if (solve(i)) {
                System.out.println(i);
            }
        }
    }
    
}
