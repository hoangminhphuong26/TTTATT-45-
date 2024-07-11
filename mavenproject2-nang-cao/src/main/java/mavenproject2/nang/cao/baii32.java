/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Áp dụng các thuật toán đã được học em hãy cài đặt chương trình giải bài toán mô
phỏng cách mã và giải mã của hệ mật RSA như sau:
- Tìm số nguyên số p, q (trong đó 100 < p, q < 500)
- Tính n = p.q; (n) = (p – 1) (q – 1)
- Chọn e (1<e< (n)) là số nguyên tố cùng nhau với (n) (gcd(e, (n)) = 1) và tính d = e-1
mod (n)
- Tính bản mã c của thông điệp m, với m = SBD + 123, c = me mod n
- Giải mã thông điệp, tính m = cd mod n
 */
public class baii32 {

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

        // chuyển n-1 về dạng (2^s)*r
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

    public static long UCLN(long a, long b) {
        long r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static long nghichDao(long a, long p) {
        long u = a;
        long v = p;
        long x1 = 1;
        long x2 = 0;
        long q, r, x;
        while (u != 1) {
            q = (long) Math.floor((double) v / u);//floor lấy cận dưới
            r = v - q * u;
            x = x2 - q * x1;
            v = u;
            u = r;
            x2 = x1;
            x1 = x;
        }
        if (x1 < 0) {
            x1 = p + x1;
        }
        return x1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap SBD: ");
        int m = scan.nextInt();
        m += 123;

        int p, q, e;
        do {
            p = (new Random().nextInt(400)) + 101;
        } while (!MillerRabin(p, 5));
        do {
            q = (new Random().nextInt(400)) + 101;
        } while (!MillerRabin(q, 5));

        long n = p * q;
        long phi = (p - 1) * (q - 1);

        e = 2;
        while (true) {
            if (UCLN(e, phi) == 1) {
                break;
            }
            e++;
        }

        long d = nghichDao(e, phi);
        long c = binhPhuongCoLap(m, e, n);
        System.out.println("p=" + p + "\nq=" + q + "\nn=" + n + "\nphi=" + phi + "\ne=" + e + "\nd=" + d);
        System.out.println("Ban ma cua thong diep " + m + " la: " + c);
        System.out.println("Giai ma " + c + " la: " + binhPhuongCoLap(c, d, n));

    }
    
}
