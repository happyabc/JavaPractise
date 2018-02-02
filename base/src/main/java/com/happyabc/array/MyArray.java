package com.happyabc.array;

import org.junit.Test;

public class MyArray {
    @Test
    public  void oneMatrix() {
        int[] a = new int[4];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        //1:第一种打印方式
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println("----------------------");
        //2:第二中打印方式
        for (int b:a
             ) {
            System.out.println(b);

        }
    }
    @Test
    public  void twoMatrix(){

        int[][]a =new int[3][4];
        for (int i=0;i<a.length;i++){
            //打印的是地址
            System.out.println(a[i]);
            for (int j=0;j<a[i].length;j++){
                System.out.println("i="+i+",j="+j+"="+a[i][j]);
                a[i][j]=i+j;
            }
        }
        //打印
        for (int i=0;i<a.length;i++){
            //打印的是地址
            System.out.println(a[i]);
            for (int j=0;j<a[i].length;j++){
                System.out.println("i="+i+",j="+j+"="+a[i][j]);
            }
        }
    }
    @Test
    public void two(){
        int[][]a ={
                {1,2,3},{4,5}
        };
        for (int i=0;i<a.length;i++){
            //打印的是地址
            System.out.println(a[i]);
            for (int j=0;j<a[i].length;j++){
                System.out.println("i="+i+",j="+j+"="+a[i][j]);
            }
        }
    }
    //数组的声明
    @Test
    public  void main() {
        int[][] ab = new int[3][5];
        int bc[][] = new int[1][2];
    }
}
