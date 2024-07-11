/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *Hai số tạo thành một cặp số thân thiết khi chúng tuân theo quy luật: Số này bằng tổng tất
cả các ước của số kia (trừ chính số đó) và ngược lại. Viết chương trình tìm hai số dạng này nhỏ
hơn N (với N nhập vào từ bàn phím)
 * @author abc
 */
public class baii6 {
    // // Hàm tính tổng các ước của n (ngoại trừ chính nó)
 static int sum(int n) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                result += i;
            }
        }
        return result;
    }
 // Hàm tìm và in ra các cặp số thân thiết
    static void solve(int n) {
        int x = 0;
        int[] check = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                int sum_i = sum(i);
                if (sum_i <= n) {
                    int sum_j = sum(sum_i);
                    if (sum_j == i && sum_i != i) {
                        x = 1;
                        System.out.println("Cap so than thiet la: (" + i + ", " + sum_i + ")");
                        check[sum_i] = 1;
                    }
                }
            }
        }
        if (x == 0) {
            System.out.println("Khong tim thay cap so nao!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap N: ");
        int n = sc.nextInt();
        solve(n);
    }
    
}
