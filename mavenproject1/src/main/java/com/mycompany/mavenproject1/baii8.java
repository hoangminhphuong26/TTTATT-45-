/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *. Một số gọi là số Т-prime nếu có có đúng 3 ước nguyên dương. Viết chương trình tìm các
số Т-prime nhỏ hơn hoặc bằng N với N cho trước nhập từ bàn phím
 * @author abc
 */
public class baii8 {

    static void solve(int i) {
        int dem = 0;
        for (int j = 2; j <= i / 2; j++) {
            if (i % j == 0) {
                dem++;
            }
        }
        if (dem == 1) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap N: ");
        int n = sc.nextInt();
        for (int i = 4; i <= n; i++) {
            solve(i);
        }
    }
    
}
