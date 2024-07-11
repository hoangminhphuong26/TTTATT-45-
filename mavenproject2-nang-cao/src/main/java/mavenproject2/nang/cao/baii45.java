/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 *Viết chương trình sinh một mảng số nguyên tố A gồm N phần tử (N nhập từ bàn phím)
sử dụng kiểm tra Miller-Rabin. In ra mảng và tính khoảng cách nhỏ nhất giữa 2 số bất kỳ trong
mảng
 */
public class baii45 {

    public static boolean fermat(long n, int t) {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        }

        for (int i = 0; i < t; i++) {
            Random random = new Random();
            // Random từ 2 đến n-2
            long a = random.nextLong(n - 3) + 2;

            // Dung binh phuong co lap de tinh a^(n-1) mod n
            long r = binhPhuongCoLap(a, n - 1, n);
            if (r != 1) {
                return false;
            }
        }
        return true;
    }

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap N: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            do {
                A[i] = (new Random().nextInt(100000 - 2) + 2);
            } while (!fermat(A[i], 5));
        }

        Arrays.sort(A);
        System.out.print("Mang A la: ");
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

        int min = A[1] - A[0];
        for (int i = n - 1; i > 0; i--) {
            if (min > A[i] - A[i - 1]) {
                min = A[i] - A[i - 1];
            }
        }

        System.out.println("\nKhoang cach min giua 2 so bat ki: " + min);
    }
    
}
