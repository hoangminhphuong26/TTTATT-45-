/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Scanner;

/**
 *
 * Tìm nghịch đảo của một số a trong trường 𝐹𝑝 với a và p được nhập từ bàn phím.
 */
public class baii38 {

    static int gcd(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int nghichDao(int a, int p) {
        if (gcd(a, p) != 1) {
            return 0;
        } else {
            int u = a;
            int v = p;
            int x1 = 1;
            int x2 = 0;
            int q, r, x;
            while (u != 1) {
                q = (int) Math.floor((double) v / u);
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
            return x1 % p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, p;
        System.out.print("Nhap p: ");
        p = sc.nextInt();
        do {
            System.out.print("Nhap a: ");
            a = sc.nextInt();
        } while (a < 1 || a > p);

        if (gcd(a, p) != 1) {
            System.out.println("Khong co nghich dao!");
        } else {
            System.out.println("Nghich dao cua " + a + " trong truong Fp voi p = " + p + " la: " + nghichDao(a, p));
        }
    }

    
}
