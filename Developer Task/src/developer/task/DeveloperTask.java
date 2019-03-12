/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developer.task;

import java.util.Scanner;

/**
 *
 * @author Nele N.
 */
public class DeveloperTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long a = 0;
        long b = 0;
        double adiv = 0;
        double bdiv = 0;
        int i = 1;

        final int ak = 16807;
        final int bk = 48271;
        final long div = 2147483647;

        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Iveskite pasirinkta skaiciu A:  ");
        a = sc.nextInt();

        System.out.println(" ");
        System.out.print("Iveskite pasirinkta skaiciu B:  ");
        b = sc.nextInt();
        while (i < 5) {

            a = a * ak;
            adiv =(double) a/div;
            System.out.println(a);
            System.out.println(adiv);
            System.out.println("");
            
            
            b = b * bk;
            bdiv = (double) b/div;
            System.out.println(b);
            System.out.println(bdiv);
            System.out.println("");
            
            i++;
        }

    }

}
