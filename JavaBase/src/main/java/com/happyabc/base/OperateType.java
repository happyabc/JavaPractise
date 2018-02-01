package com.happyabc.base;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class OperateType {
    public static void main(String[] args) {
        int type = 0;
        if (type == 1) {
            //点播
        }

        if (type == 2) {
            //直播
        }
    }

    public Object getProperty(Object owner, String fieldName) throws Exception {
        //得到该对象的Class。
        Class ownerClass = owner.getClass();
        //通过Class得到类声明的属性。
        Field field = ownerClass.getField(fieldName);
        //通过对象得到该属性的实例，如果这个属性是非公有的，这里会报IllegalAccessException。
        Object property = field.get(owner);
        return property;
    }

    //类的静态属性
    public Object getStaticProperty(String className, String fieldName)
            throws Exception {
        //首先得到这个类的Class。
        Class ownerClass = Class.forName(className);
        // 和上面一样，通过Class得到类声明的属性。
        Field field = ownerClass.getField(fieldName);
        // 这里和上面有些不同，因为该属性是静态的，所以直接从类的Class里取。
        Object property = field.get(ownerClass);
        return property;
    }

    public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        //首先还是必须得到这个对象的Class。
        Class ownerClass = owner.getClass();
        //配置参数的Class数组，作为寻找Method的条件。
        Class[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }
        //通过methodName和参数的argsClass（方法中的参数类型集合）数组得到要执行的Method。
        Method method = ownerClass.getMethod(methodName, argsClass);
        //执行该Method.invoke方法的参数是执行这个方法的对象owner，和参数数组args，可以这么理解：owner对象中带有参数args的method方法。返回值是Object，也既是该方法的返回值。
        return method.invoke(owner, args);
    }

    //执行某个类的静态方法
    public Object invokeStaticMethod(String className, String methodName,
                                     Object[] args) throws Exception {
        Class ownerClass = Class.forName(className);

        Class[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

        Method method = ownerClass.getMethod(methodName, argsClass);

        return method.invoke(null, args);
    }

    //新建实例
    public Object newInstance(String className, Object[] args) throws Exception {
        Class newoneClass = Class.forName(className);
        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }
        Constructor cons = newoneClass.getConstructor(argsClass);
        return cons.newInstance(args);
    }

    public boolean isInstance(Object obj, Class cls) {
        return cls.isInstance(obj);
    }

    public Object getByArray(Object array, int index) {
        return Array.get(array, index);
    }

}
