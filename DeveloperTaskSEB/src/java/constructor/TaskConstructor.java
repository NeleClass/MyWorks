/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NeleN
 */
public class TaskConstructor {

    private Integer a;
    private Integer b;
    private double adiv;
    private double bdiv;
    final Integer ak = 16807;
    final Integer bk = 48271;
    final Integer div = 2147483647;
    private static final List numbers = new ArrayList();

    public TaskConstructor(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public static List getAll() {
        return numbers;
    }


    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public void setA(Integer a) {
        this.a = a;
    }
    
    public void setB(Integer b) {
        this.b = b;
    }

    public double getAdiv() {
        return adiv;
    }

    public void setAdiv(double adiv) {
        adiv = (a*ak)/div;
        this.adiv = adiv;
    }

    public double getBdiv() {
        return bdiv;
    }

    public void setBdiv(double bdiv) {
        bdiv = (b*bk)/div;
        this.bdiv = bdiv;
    }

    @Override
    public String toString() {
        return "TaskConstructor{" + "a=" + a + ", b=" + b + ", adiv=" + adiv + ", bdiv=" + bdiv + ", ak=" + ak + ", bk=" + bk + ", div=" + div + ", numbers=" + numbers + '}';
    }

}
