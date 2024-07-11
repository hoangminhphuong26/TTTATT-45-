/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Scanner;

/**
 *
 *Lập trình tìm kiếm xâu S1 trong xâu S2 theo thuật toán Knutt-Morris-Patt. Trong trường
hợp nào thì thuật toán Boyer-Moore được xem là cải tiến hơn thuật toán tìm kiếm vét cạn?
 */
public class baii37 {

    static void KMP(char[] T, char[] P) {
        int i, j;
        i = j = 0;
        while (i + P.length <= T.length) {
            int index = i;
            while (T[index] == P[j]) {
                index++;
                j++;
                if (j == P.length) {
                    System.out.println("Xau \"" + String.valueOf(P) + "\" nam trong xau \"" + String.valueOf(T) + "\" bat dau tu vi tri " + (i + 1) + " va ket thuc tai vi tri thu " + index);
                    return;
                }
            }
            i = i + j - F(P, j);
            j = (F(P, j) == -1) ? 0 : F(P, j);//
        }
        System.out.println("Khong tim thay xau \"" + String.valueOf(P));
    }

    static int F(char[] P, int j) {
        if (j == 0) {
            return -1;
        } else if (j == 1) {
            return 0;
        }
        String p = String.valueOf(P);
        int count = 0, k = j - 1;
        for (int i = 0; i < j; i++) {
            if (!(p.substring(i, j).equalsIgnoreCase(p.substring(k, j)))) {
                return count;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap T: ");
        char[] T = scan.nextLine().toCharArray();
        System.out.print("Nhap P: ");
        char[] P = scan.nextLine().toCharArray();
        KMP(T, P);
    }
    
}
