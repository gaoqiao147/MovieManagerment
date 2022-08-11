package com.freesoft.reflection;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射和File完成以下功能
 * 1.利用Class类的forName方法得到File类的class对象
 * 2.在控制台打印Fi引e类的所有构造器
 * 3.通过newInstance的方法创建File对象，并创建E：\newText.txt文件
 * 提示：创建文件的正常写法如下：
 * .File file=new File("dlaa.txt"):/内存
 * file.createNewFile()；/方法，才能真正的创建文件
 */
public class ReflectionTest {
    @Test
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取文件类
        Class<?> aClass = Class.forName("java.io.File");
        //调用file中构造器(获取指定的构造器)
        Constructor<?> declaredConstructors = aClass.getDeclaredConstructor(String.class);
        String path = "E:\\newText.txt";
        //通过构造器创建实例
        Object o1 = declaredConstructors.newInstance(path);
        //调用方法,创建文件
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(o1);
        //判断文件是否成功
        File file = new File("E:\\newText.txt");
        if (file.exists()) {
            System.out.println("创建文件成功！");
        } else {
            System.out.println("创建文件失败！");
        }
    }
}
