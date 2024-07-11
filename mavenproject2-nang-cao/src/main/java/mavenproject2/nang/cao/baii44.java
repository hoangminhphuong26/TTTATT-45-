/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Scanner;

/**
 *
 *Cho mảng A gồm các số nguyên thuộc 𝐹𝑝 nhập vào từ bàn phím, hãy viết chương trình in
ra mảng B có các phần tử là nghịch đảo của các phần tử tương ứng trong A. 
 */
public class baii44 {
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
            return x1;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap p: ");
        int p = scan.nextInt();
        System.out.print("Nhap so luong phan tu: ");
        int n = scan.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]= ");
            A[i] = scan.nextInt();
        }

        int[] B = new int[n];
        System.out.println("cac phan tu nghich dao");
        for (int i = 0; i < n; i++) {
            B[i] = nghichDao(A[i], p);
            if (B[i] == 0) {
                System.out.println("B[" + i + "] KHONG co nghich dao!");
            } else {
                System.out.println("B[" + i + "]= " + B[i]);
            }
        }
    }
    
}
