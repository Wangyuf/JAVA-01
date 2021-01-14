package Week_01;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;

/**
 * @program: JAVA-01 HelloClassLoader.java
 * @description:
 * @author: cc
 * @create: 2021-01-10 01:10
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method sayHello = helloClass.getDeclaredMethod("hello");
            Object o = helloClass.newInstance();
            sayHello.invoke(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("Week_01/Hello.xlass");
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255-bytes[i]);
        }
        //写入文件
        this.createFile(bytes);
        return defineClass(name, bytes, 0, bytes.length);
    }
    
    /**
     * @Description: 写出源文件
     * @Author: cc
     * @create 2021/1/10 2:21
     */
    public void createFile(byte[] bytes){
        File newFile = new File("Week_01/Hello.class");
        try {
            if (!newFile.exists()) {
                //创建文件
                newFile.createNewFile();
            }
            //创建输出流，写入数据
            FileOutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(bytes);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
