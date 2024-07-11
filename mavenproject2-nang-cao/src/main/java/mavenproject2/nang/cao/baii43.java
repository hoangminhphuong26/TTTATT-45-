/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Cho N nhập vào từ bàn phím (0<N<1000), sinh một số nguyên tố p<100. Hãy viết
chương trình tìm tất cả các số nguyên a<N sao cho a
p mod N là số nguyên tố.
 */
public class baii43 {

   public static boolean fermat(long n, int t) {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        }

        for (int i = 0; i < t; i++) {
            Random random = new Random();
            // Random từ 2 đến n-2
            long a = random.nextLong(n - 3) + 2;

            // Dung binh phuong co lap de tinh a^(n-1) mod n
            long r = binhPhuongCoLap(a, n - 1, n);
            if (r != 1) {
                return false;
            }
        }
        return true;
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, p;
        do {
            System.out.print("Nhap N: ");
            n = scan.nextInt();
        } while (n < 1 || n > 1000);
        do {
            p = (new Random().nextInt(1000 - 2)) + 2;
        } while (!fermat(p, 5));
        System.out.print("p = " + p + "\nSo a thoa man la: ");
        for (long i = 1; i < n; i++) {
            long R = binhPhuongCoLap(i, p, n);
            if (fermat(R, 5)) {
                System.out.print(i + " ");
            }
        }
    }
    
}
