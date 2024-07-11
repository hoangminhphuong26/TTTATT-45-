/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *Đặt S1, S2 là các mảng chứa giá trị bình phương của các số nguyên. Hãy viết chương
trình in ra số lượng tất cả các số nguyên tố nằm trong khoảng [a,b] sao cho số này cũng là tổng
của hai số x và y với x thuộc S1 và y thuộc S2. Trong đó, a,b là các số được nhập từ bàn phím
Ví dụ: với a=10, b =15, in ra giá trị là 1 vì trong khoảng [10,15] chỉ có 2 số nguyên tố 11 và 13,
nhưng chỉ có 13 = 2^2 + 3^2=4+9.
 * @author abc
 */
import java.util.Random;
import java.util.Scanner;
public class baii24 {

    
    public static boolean fermat(int n, int t) {
        int r, a;
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 1; i <= t; i++) {
            //chọn ngẫu nhiên a trong khoảng 2<=a<=n-2
            a = (new Random().nextInt(n - 3)) + 2;
            r = Binhphuongcolap(a, n - 1, n);
            if (r != 1) {
                return false;
            }
            a++;
        }
        return true;
    }

    public static int Binhphuongcolap(int a, int x, int n) {
        int b = 1;
        if (x == 0) {
            return b;
        }
        int A = a;
        int j = 0;

        int[] nhiPhan = new int[10000];
        while (x > 0) {
            nhiPhan[j++] = x % 2;
            x = x / 2;
        }
        if (nhiPhan[0] == 1) {
            b = a;
        }
        for (int i = 1; i < j; i++) {
            A = (int) (Math.pow(A, 2) % n);
            if (nhiPhan[i] == 1) {
                b = ((A * b) % n);
            }
        }
        return b;
    }

    static boolean checkCondition(int n) {
        for (int i = 1; i * i < n; i++) {
            if (n - i * i == Math.pow((int) Math.sqrt(n - i * i), 2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        System.out.print("Nhap b: ");
        int b = sc.nextInt();

        // Kiểm tra các số nguyên tố trong khoảng a-b
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (checkCondition(i) && fermat(i, 5)) {
                System.out.print(i + " ");
                count++;
            }
        }

        System.out.println("");
        System.out.println("So cac so thoa man la: " + count);
    }
    
}
