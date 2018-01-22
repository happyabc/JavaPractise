package com.happyabc.date;

import org.junit.Test;

import java.util.Date;

public class Time {
    @Test
    public  void time(){
        Date date=new Date(100000000);
        System.out.println(date);

       long current=date.getTime();
        System.out.println(current);
    }
}
