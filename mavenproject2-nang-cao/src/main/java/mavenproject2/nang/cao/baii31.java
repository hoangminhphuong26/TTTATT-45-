/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Áp dụng theo các thuật toán đã được học trong phần lí thuyết em hãy cài đặt chương
trình:
- Tìm số nguyên tố k gần nhất với phần số của mã số sinh viên của mình (trong trường hợp
khoảng cách bằng nhau thì lấy số nhỏ hơn).
- Từ số k tìm được tính ak mod n với a = SBD, n = 123456
 */
public class baii31 {

    static int msv, sbd;

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

    static int solve() {
        int low, hight;
        low = hight = msv;
        while (true) {
            low = low - 1;
            hight = hight + 1;

            if (MillerRabin(low, 5)) {
                return low;
            }
            if (MillerRabin(hight, 5)) {
                return hight;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap MSV: ");
        msv = sc.nextInt();
        System.out.print("Nhap SBD: ");
        sbd = sc.nextInt();

        int k = solve();
        System.out.println("So nguyen to k gan nhat la: " + k);

        System.out.println("a^k mod n = " + binhPhuongCoLap(sbd, k, 123456));

    }
    
}
