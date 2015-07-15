package com.netcracker.edu.java.tasks;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by user on 09.07.2015.
 */
public class Main {
    public static void main(String[] args) {

        int i=1;
        switch(i){
            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
            default:
                System.out.println(3);

        }
        int x=5,y=0;
        //System.out.println(x/y);
        double a=6,b=0;
        System.out.println(a/b);
        StringBuffer aa=new StringBuffer("One");
        StringBuffer bb=new StringBuffer("Two");
        swap(aa, bb);
        System.out.println(aa);
        System.out.println(bb);
        B d=new B();
        int e=5;
        //int r=078;
        double t=9;
        //int u=5.5;
        short o=7;
        //float p=7.2;
        char l=123;
        double k=0x123D;
        //short j=3L;
        int h='r';
        int g=0x123F;
        int v=3;
        double n=5.5;
        n=v;
        //byte f=255;
        //System.out.println(d.B.A.print2());
        //System.out.println(d.super.x);

        d.print();
        ArrayList arr=new ArrayList();
        arr.add(4);
        arr.add(4);
        arr.add(4);
        for(int numbir:arr){
            System.out.println(numbir);

        }

    }
    static void swap(StringBuffer a,StringBuffer b){
        a.append(" more");
        b=a;
    }



}

class A {
    String x="A";
    void print2(){
        System.out.println("A");
    }
    void print(){
        System.out.println(x);
        print2();
    }

}

class B extends A{
    String x="B";
    B(){
        x=null;
    }
    void print2(){
        System.out.println("B");
    }
}
