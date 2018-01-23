package com.happyabc.classload;

//***********************************************************

public class CompilConstant {

    public static void main(String[] args) {
        System.out.println(Test.a);
        System.out.println(Test.c);
    }

}
                                                
class Test {
    static {
        System.out.println("Class Test Was Loaded !");
    }
    public static final int a =10;
    public static final int c = "test".length();
    public void a(String str){
        final  int a=(int)(Math.random());
        final  int b=str.length();
    }
}