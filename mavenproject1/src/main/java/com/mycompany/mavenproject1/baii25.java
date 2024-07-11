/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 Cho 2 số M và N thoả mãn điều kiện: 1<=N<=10000; 2<M<=100; Hãy viết chương trình
xác định xem số N có thể được phân tích thành tổng của M số nguyên tố hay không? Nếu có thì in
ra các số đó.
Ví dụ: N=10 và M=3, thì 10=2+3+5 do đó kết quả trả về là thoả mãn và in ra 3 số 2,3,5
 * @author abc
 */
public class baii25 {

    static int n, m, count, check, dem, total;
    static int[] bo, S, NT;

    static void input(Scanner sc) {
        System.out.print("Nhap n: ");
        n = sc.nextInt();
        System.out.print("Nhap m: ");
        m = sc.nextInt();
        count = 0;
        check = 0;
        dem = 0;
        total = 0;
        S = new int[n];
        bo = new int[m];
        NT = new int[10000];
    }

    static void Sieve() {
        S = new int[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (S[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    S[j] = 1;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (S[i] == 0) {
                NT[count++] = i;
            }
        }
    }

    static void phanTich(int index) {
        if (dem == m || check == 1 || total == n) {
            return;
        }
        for (int i = index; i < count; i++) {
            total += NT[i];
            bo[dem] = NT[i];
            dem++;

            if (total == n && dem == m) {
                check = 1;
                System.out.println("YES");
                for (int k = 0; k < m; k++) {
                    System.out.print(bo[k] + " ");
                }
                return;
            } else {
                phanTich(i + 1);
            }

            total -= NT[i];
            dem--;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input(sc);
        Sieve();
        phanTich(0);
        if (check == 0) {
            System.out.println("NO");
        }
    }
    
}
