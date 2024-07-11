/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.util.Scanner;
/**
 Áp dụng thuật toán đã được học để viết chương trình tính tổng của hai số nguyên lớn,
hiển thị dưới mạng mảng và dạng số nguyên
 * @author abc
 */
public class baii18 {

    public static int w = 8;
    public static long p = 2147483647;
    public static int t = 4;
    static int s;

    static long[] congCXB(long[] a, long[] b) {
        long[] result = new long[t];

        s = 0;
        for (int i = 0; i < t; i++) {
            long c = a[3 - i] + b[3 - i] + s;
            if (c >= Math.pow(2, w)) {
                s = 1;
                c = c % (long) Math.pow(2, w);
            } else {
                s = 0;
            }
            result[3 - i] = c;
        }
        return result;
    }

    static long mang_Thanh_So(long[] a) {
        long n = 0;
        for (int i = t - 1; i >= 0; i--) {
            n += Math.pow(2, i * w) * a[3 - i];
        }
        return n;
    }

    static long[] so_Thanh_Mang(long a) {
        long[] result = new long[t];
        for (int i = 3; i >= 0; i--) {
            result[3 - i] = a / (long) (Math.pow(2, w * i));
            a %= (Math.pow(2, w * i));
        }
        return result;
    }

    static void hienThiMang(long[] a) {
        System.out.print("[ ");
        for (int i = 0; i < t; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen a: ");
        long a = sc.nextLong();
        System.out.print("Nhap so nguyen b: ");
        long b = sc.nextLong();

        System.out.print("So a: ");
        long[] arr_a = so_Thanh_Mang(a);
        hienThiMang(arr_a);
        System.out.print("So b: ");
        long[] arr_b = so_Thanh_Mang(b);
        hienThiMang(arr_b);

        System.out.print("Tong a + b: ");
        long[] arr_sum = congCXB(arr_a, arr_b);
        hienThiMang(arr_sum);

        System.out.println("Dang so nguyen: a + b = " + mang_Thanh_So(arr_sum));

    }
    
}
