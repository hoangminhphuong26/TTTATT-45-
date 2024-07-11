
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**. Viết chương trình tìm hai số nguyên tố nhỏ hơn hoặc bằng N với N nhập vào từ bàn
phím, sao cho tổng và hiệu của chúng đều là số nguyên tố.
 */
public class baii13 {

     static int[] s;
    static int[] a;

    static void sieve(int n) {
        s = new int[2 * n + 1];
        a = new int[n];
        s[0] = s[1] = 1;
        for (int i = 2; i < Math.sqrt(2 * n) + 1; i++) {
            if (s[i] == 0) {
                for (int j = i * i; j <= 2 * n; j += i) {
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
        int i = 0;
        while (a[i + 1] != 0) {
            int j = i + 1;
            while (a[j] != 0) {
                if (s[a[i] + a[j]] == 0 && s[Math.abs(a[i] - a[j])] == 0) {
                    System.out.println("2 so nguyen to thao man: " + " " + a[i] + " " + a[j]);
                }
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao N: ");
        int n = sc.nextInt();
        sieve(n);
        solve(n);
    }
    
}
