/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author macbookair
 */
public class IOStream {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
                //naudojant FileInputStream ir FileOutputStream
        FileInputStream fis = new FileInputStream("/Users/macbookair/Desktop/Hello.txt");
       
//        int i = 0;
//        while((i=fis.read())!=-1){
//            System.out.println(i);
//        }
        // fis.close();
        FileOutputStream fos = new FileOutputStream("/Users/macbookair/Desktop/HelloOut.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        

//        String s = "";
//        while ((s=br.readLine())!= null){
//            System.out.println(s);
//        }
//       br.close();
//       isr.close();
//       fis.close();
        String j = "";
        while ((j = br.readLine()) != null) {
            System.out.println(j);
            byte[] b = j.getBytes();
            fos.write(b);
            
        }

        br.close();
        isr.close();
        fis.close();
        fos.close();
            // Arba naudojant FileReader ir FileWriter
        FileReader fr = new FileReader("/Users/macbookair/Desktop/FileReader.txt");
        FileWriter fw = new FileWriter("/Users/macbookair/Desktop/FileWriter.txt");
        Scanner in = new Scanner(new File("/Users/macbookair/Desktop/FileReader.txt"));
        int k = 0;
        while ((k = fr.read()) != -1) {
            fw.write(k);
        }
 
        System.out.println("");
        while (in.hasNext()) {
            String w = in.next();
            fw.write("\n" + w);
            System.out.println(w + " ");
        }
        fr.close();
        fw.close();
        in.close();
    }

}
