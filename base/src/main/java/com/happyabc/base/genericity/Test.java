package com.happyabc.base.genericity;

/**
 * Test
 *
 * @author thekings
 * @date 2015-11-18
 * @Time 13:01
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//T1,T2都是随便定义的东西，注意1:他们不会关联到其他类，只是在本类中通用，只是告诉我们new的时候要加入泛型

public class Test<T1, T2> {

    public static void main(String[] args) {
        System.out.println(new Test().getaa());
        new Test<String, String>().getbb("");
        new Test().getcc(Test.class);
        //注意下6:面这个HashMap的括号里面不能是T,E,T1,T2等不确定的东西,但可以是?

        HashMap<Object, String> map = new HashMap<Object, String>();
        List<?> list = new ArrayList<String>();
    }


    T2 getaa() {
        //注意2:T2将自动转型为String,这个不需要去担心
        return (T2) "few";
    }


    public <T> void getbb(T x) {
        //注意3:Class<T>前面缺少<T>将编译错误
        System.out.println(x.getClass().getName());
    }


    public <T> Class<?> getcc(Class<T> a) {
        //getcc前面的Class<T>前面缺少<T>将编译错误,注意4:Class<?>里面的问号可以换成T
        System.out.println(a.getClass().getName());
        //注意5:参数里面的Class<T>最大的好处是如果方法里面定义了泛型，可以自动获取类型值，比如如下的List<T>可以自动获取到a的类型，不必强调死
        List<T> aa = new ArrayList<T>();
        System.out.println(aa);
        return a;
    }
}

