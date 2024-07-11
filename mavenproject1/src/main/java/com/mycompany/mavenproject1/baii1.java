/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mavenproject1;
//Một số gọi là Q-prime khi nó có đúng 4 ước số nguyên dương. Hãy viết chương trình in ra
//các số Q-Prime nhỏ hơn hoặc bằng một số N cho trước nhập từ bàn phím
import java.util.Scanner;

/**
 *
 * @author abc
 */
public class baii1 {

    public static void main(String[] args) { int n;
        Scanner sc= new Scanner(System.in);
        
        do{
        System.out.printf("Nhap n: ");
        n=sc.nextInt();
        }while (n<0);
        
        System.out.printf("tat ca so Q_Prime nho hon hoac bang %d la:\n ",n );
        for (int i=0;i<=n;i++)
        {
            if(check(i))
                System.out.print(i+" ");
        }
    }
    
    public static  boolean check (int n){
        int d=2;
        for (int i=2; i<=n/2; i++ ){
            if (n%i==0)
                d++;
        }
        return d==4;
        
    }
    
}
// input :8
// output 6 8 
// đã check

