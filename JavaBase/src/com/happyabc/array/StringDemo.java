package com.happyabc.array;

public class StringDemo {
    static int a;
    final int b = 0;

    public static void main(String[] args) {
        System.out.println(a);
        String gh = new String("a");
        System.out.println("i=(0)=" + gh.getClass() + "@" + gh.hashCode());
        for (int i = 1; i <= 4; i++) {
            gh = gh + i;
            System.out.println("i=(" + i + ")=" + gh.getClass() + "@" + gh.hashCode());
        }
    }

}
