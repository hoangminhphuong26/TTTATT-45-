/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Scanner;

/**
 *
 * 6. Lập trình tìm kiếm xâu S1 trong xâu S2 theo thuật toán Boyer-Moore, in giá trị của bảng.
Trong trường hợp nào thì thuật toán Boyer-Moore được xem là cải tiến hơn thuật toán tìm kiếm
vét cạn.
 */
public class baii36 {

    static int min(int a, int b) {
        return a > b ? b : a;
    }

    // hàm L() trả về vị trí của a gần cuối nhất 
    static int L(char a, char[] P) {
        for (int i = P.length - 1; i >= 0; i--) {
            if (a == P[i]) {
                return i;
            }
        }
        return -1;
    }

    static void BoyerMoore(char[] T, char[] P) {
        int i, j;
        int m = P.length;
        i = j = m - 1;
        while (i < T.length) {
            // Nếu P[j] != T[i] sử dụng ct cập nhật vị trí i, j
            if (P[j] != T[i]) {
                i = i + m - min(j, 1 + L(T[i], P));
                j = m - 1;
            } // Nếu P[j] = T[i] tiếp tục kiểm tra các phần tử trc
            else {
                i--;
                j--;
            }

            if (j == -1) {
                System.out.println("Xau \"" + String.valueOf(P) + "\" nam trong xau \"" + String.valueOf(T) + "\" bat dau tu vi tri " + (i + 1) + " va ket thuc tai vi tri " + (i + P.length));
                return;
            }
        }
        System.out.println("Khong tim thay xau \""+String.valueOf(P)+"\" trong xau \""+String.valueOf(T)+"\"");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap T: ");
        char[] T = sc.nextLine().toCharArray();
        System.out.print("Nhap P: ");
        char[] P = sc.nextLine().toCharArray();
        BoyerMoore(T, P);
    }
}
// nhanh hơn nhiều, thực hiện tốt với bảng chữ lớn, tốt với văn bản thường, kém với nhị phân

    

