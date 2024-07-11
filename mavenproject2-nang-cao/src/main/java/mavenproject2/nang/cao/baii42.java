/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Random;

/**
 *
 * Viết chương trình sinh ra 2 số nguyên tố 0<p,q<1000 và kiểm tra với với số
 * 0<a<100 thì liệt kê những số a thoả mãn: a p mod q là số nguyên tố
 */
public class baii42 {

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
        long p, q;
        do {
            p = (new Random().nextLong(1000 - 2)) + 2;
        } while (!fermat(p, 5));
        do {
            q = (new Random().nextInt(1000 - 2)) + 2;
        } while (!fermat(q, 5));
        System.out.println("p=" + p + "\nq=" + q);

        int x = 0;
        System.out.println("Cac so a thoa man a^" + p + " mod " + q + " la so nguyen to la: ");
        for (long i = 1; i < 100; i++) {
            long R = binhPhuongCoLap(i, p, q);
            if (fermat(R, 5)) {
                System.out.println(i + " ");
                x = 1;
            }
        }
        if (x == 0) {
            System.out.println("Khong ton tai gia tri nao!");
        }
    }

}
