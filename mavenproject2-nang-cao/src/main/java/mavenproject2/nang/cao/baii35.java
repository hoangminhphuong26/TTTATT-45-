/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Random;
import java.util.Scanner;

/**
 *
 *Cài đặt thuật toán kiểm tra số nguyên tố Miller-Rabin in ra kết luận về 1 số nguyên
dương N nhập vào từ bàn phím với xác suất kết luận tương ứng sau thuật toán.
 */
public class baii35 {

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

    static double tinhxacxuat(int t) {
        return 1 - Math.pow((double) 1 / 4, t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so kiem tra: ");
        long n = sc.nextLong();
        System.out.print("Nhap so lan lap: ");
        int t = sc.nextInt();
        if (MillerRabin(n, t)) {
            System.out.println("N là so nguyen to voi sac xuat la: " + tinhxacxuat(t));
        } else {
            System.out.println("Hop so");
        }
    }
    
}
