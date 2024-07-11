/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Cho mảng A nhập từ bàn phím gồm các số nguyên dương. Hãy viết chương trình tìm các
cặp số (i,j) trong mảng A sao cho ước chung lớn nhất của chúng là một số nguyên tố.
 */
public class baii39 {

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

    public static int UCLN(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap kich thuoc mang: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]= ");
            A[i] = sc.nextInt();
        }

        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (MillerRabin(UCLN(A[i], A[j]), 5)) {
                    tmp++;
                    System.out.println("(" + A[i] + "," + A[j] + ")");
                }
            }
        }
        if (tmp == 0) {
            System.out.println("khong co!");
        }
    }
}
