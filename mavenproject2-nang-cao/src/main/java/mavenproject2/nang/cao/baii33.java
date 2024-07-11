/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mavenproject2.nang.cao;

import java.util.Scanner;

/**
 *
 * @author abc
 */
public class baii33 {

    static int[] g;

    // Hàm cộng 2 đa thức 
    static int[] add(int[] a, int[] b) {
        // Tạo mảng kết quả với độ dài là độ dài chuỗi lớn hơn
        int length = Math.max(a.length, b.length);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (i < a.length) {
                // XOR với a[i]
                result[i] ^= a[i];
            }
            if (i < b.length) {
                // XOR vói b[i]
                result[i] ^= b[i];
            }
        }
        return result;
    }

    // Hàm nhân 2 đa thức 
    static int[] multiply(int[] a, int[] b) {
        // Tạo mảng kết quả với độ dài là tổng 2 chuỗi
        int[] result = new int[a.length + b.length - 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                // XOR kết quả ở vị trí i + j với tích ai * bi
                result[i + j] ^= a[i] * b[j];
            }
        }
        return mod(result, g);
    }

    static int[] mod(int[] a, int[] mod) {
        int[] result = a.clone();
        int modLength = mod.length;
        // vòng lặp ngoài loại bỏ đi những bậc cao nhất của a
        for (int i = a.length - 1; i >= modLength - 1; i--) {
            // nếu hệ số thứ i là 1 thì ta cần loại bỏ đi bặc này bằng cách XOR với mod đã được dịch đúng vị trí
            if (result[i] == 1) {
                // vòng lặp thực hiện XOR với mod
                for (int j = 0; j < modLength; j++) {
                    // dịch mod để cùng bậc với result sau đó xor
                    result[i - j] ^= mod[modLength - 1 - j];
                }
            }
        }

        // loại bỏ đi các số 0 ở cuối kết quả
        int k = result.length - 1;
        while (k >= 0 && result[k] == 0) {
            k--;
        }
        if (k < 0) {
            return new int[]{0};
        }
        int[] trimmedResult = new int[k + 1];
        System.arraycopy(result, 0, trimmedResult, 0, trimmedResult.length);
        return trimmedResult;
    }

    // Hàm chia đa thức
    static int[] divide(int[] a, int[] b) {
        int[] result = new int[a.length];
        int[] remainder = a.clone(); // phần dư
        int b_degree = b.length - 1; // bậc của b

        // vòng lặp ngoài loại bỏ đi những bậc cao nhất của a
        for (int i = a.length - 1; i >= b_degree; i--) {
            // nếu hệ số thứ i là 1 thì ta cần loại bỏ đi bặc này bằng cách XOR a với b đã được dịch đúng vị trí
            if (remainder[i] == 1) {
                result[i - b_degree] = 1;
                // vòng lặp thực hiện XOR với b
                for (int j = 0; j < b_degree; j++) {
                    // dịch b để cùng bậc với result sau đó xor
                    remainder[i - j] ^= b[b_degree - 1 - j];
                }
            }
        }
        return result;
    }

    static String bin_To_String(int[] bin) {
        StringBuilder sb = new StringBuilder();
        for (int i = bin.length - 1; i >= 0; i--) {
            if (bin[i] == 1) {
                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                switch (i) {
                    case 0 ->
                        sb.append("1");
                    case 1 ->
                        sb.append("x");
                    default ->
                        sb.append("x^").append(i);
                }
            }
        }
        return sb.toString();
    }

    static int[] string_To_Bin(String s) {
        String[] terms = s.split("\\+");
        int degree = 0;
        for (String term : terms) {
            int currentDegree;
            if (term.contains("x^")) {
                currentDegree = Integer.parseInt(term.substring(term.indexOf('^') + 1).trim());
            } else if (term.contains("x")) {
                currentDegree = 1;
            } else {
                currentDegree = 0;
            }
            degree = Math.max(degree, currentDegree);
        }

        int[] bin = new int[degree + 1];
        for (String term : terms) {
            int index;
            if (term.contains("x^")) {
                index = Integer.parseInt(term.substring(term.indexOf('^') + 1).trim());
            } else if (term.contains("x")) {
                index = 1;
            } else {
                index = 0;
            }
            bin[index] = 1;
        }
        return bin;
    }

    static int[] extend_Euclide(int[] a, int[] b) {
        int[] x0 = {1}, x1 = {0};
        int[] y0 = {0}, y1 = {1};
        int[] q, r, x, y;
        while (b.length > 1 || b[0] != 0) {
            System.out.println("");
            q = divide(a, b);
            System.out.println("q: " + bin_To_String(q));
            r = mod(a, b);
            System.out.println("r: " + bin_To_String(r));
            x = add(x0, multiply(q, x1));
            System.out.println("x: " + bin_To_String(x));
            y = add(y0, multiply(q, y1));
            System.out.println("y: " + bin_To_String(y));
            a = b;
            b = r;
            x0 = x1;
            x1 = x;
            y0 = y1;
            y1 = y;
        }
        return x0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap a(x): ");
        String inputA = scanner.nextLine();
        System.out.print("Nhap g(x): ");
        String inputG = scanner.nextLine();
        int[] a = string_To_Bin(inputA);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        g = string_To_Bin(inputG);
        int[] b = string_To_Bin(inputG);
        for (int i = 0; i < g.length; i++) {
            System.out.println(g[i]);
        }
        int[] inverseA = extend_Euclide(a, b);
        System.out.println("a^-1(x) = " + bin_To_String(inverseA));
    }
    
}
