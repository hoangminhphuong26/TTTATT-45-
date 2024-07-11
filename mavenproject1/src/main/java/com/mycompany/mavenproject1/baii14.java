/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
Viết chương trình tìm số nguyên tố có ba chữ số, biết rằng nếu viết số đó theo thứ tự
ngược lại thì ta được một số là lập phương của một số tự nhiên.
 * 
 */
public class baii14 {
static int[] s;

    static int reverse(int x) {
        long temp;
        long rev = 0;
        while (x != 0) {
            temp = x % 10;
            rev = rev * 10 + temp;
            x = x / 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) rev;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int[] sieve(int l, int r) {
        s = new int[r - l + 1];
        int[] newA = new int[r - l + 1];
        for (int i = 2; i < Math.sqrt(r); i++) {
            for (int j = max(i * i, (l + i - 1) / i * i); j <= r; j += i) {
                s[j - l] = 1;
            }
        }
        int j = 0;
        for (int i = l; i <= r; i++) {
            if (s[i - l] == 0) {
                newA[j++] = i;
            }
        }
        return newA;
    }

    public static void main(String[] args) {
        int l = 100;
        int r = 999;
        int[] a = sieve(l, r);
        int i = 0;
        while (a[i] != 0) {
            int reverseNumber = reverse(a[i]);
            int x = (int) Math.cbrt(reverseNumber);
            if (Math.pow(x, 3.0) == reverseNumber) {
                System.out.println("So nguyen to thoa man la: " + a[i]);
            }
            i++;
        }
    }
    
}
