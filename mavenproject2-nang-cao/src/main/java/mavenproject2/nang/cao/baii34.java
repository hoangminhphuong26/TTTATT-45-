/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Random;
import java.util.Scanner;

/**
 *
 Cài đặt thuật toán kiểm tra số nguyên tố Fermat. Trong trường hợp số nào thì thuật toán
cho kết quả kiểm tra sai
 */
public class baii34 {

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
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        long n = sc.nextLong();
        System.out.print("Nhap t: ");
        int t = sc.nextInt();
        if (fermat(n, t)) {
            System.out.println("Nguyen to");
        } else {
            System.out.println("Hop so");
        }
    }
    // trong truong hop so lan lap qua it dan den bi ket luan sai do so do la so nguyen to gia
    
}
