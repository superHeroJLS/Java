package com.jiangls.serializable;

import com.jiangls.serializable.handle.Demo00DomainAclHandleImpl;
import com.jiangls.serializable.handle.DomainAclHandle;

import java.io.*;

public class SerializationMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        /*
        * 1 Demo00DomainAclHandleImpl实例序列化写入文件ByteArrayOutputStream
        */
        // serialize
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(byteArrayOutput);
        DomainAclHandle demo = new Demo00DomainAclHandleImpl();
        oout.writeObject(demo);
        byte[] demoArraySerialized = byteArrayOutput.toByteArray();
        oout.close();
        System.out.println("length of demo array after serialize: " + demoArraySerialized.length);

        // deserialize
        ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(demoArraySerialized));
        DomainAclHandle demoDeserialized = (DomainAclHandle) oin.readObject();
        oin.close();
        System.out.println(demoDeserialized);

        // 调用反序列化之后对象的方法getDomainActions()
        System.out.println("DomainAclHandle Code: " + demoDeserialized.getCode());
        System.out.println("All of DomainActions of DomainAclHandle: ");
        demoDeserialized.getDomainActions().forEach(System.out::println);
        System.out.println("DataMap of DomainAclHandle: ");
        System.out.println(demoDeserialized.getDataMap(null));

        // ------------------------------分割线-------------------------------------
        /*
        * 1 Demo00DomainAclHandleImpl实例序列化写入文件d://demo.out中
        * 2 Demo00DomainAclHandleImpl类型修改名称为Demo00DomainAclHandleImplXXX
        * 3 读取d://demo.out反序列
        * 4 确认Demo00DomainAclHandleImpl类型不存在时，序列化后Demo00DomainAclHandleImpl实例能否反序列化成功
        * 5 实验确认Demo00DomainAclHandleImpl类型不存在，序列化后Demo00DomainAclHandleImpl实例反序列化失败，抛出异常：java.lang.ClassNotFoundException
        * */
        // serialize
//        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("d://demo.out"));
//        DomainAclHandle demo = new Demo00DomainAclHandleImpl();
//        oout.writeObject(demo);
//        oout.close();

        // deserialize
//        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("d://demo.out"));
//        DomainAclHandle demoDeserialized = (DomainAclHandle) oin.readObject();
//        oin.close();
//        System.out.println(demoDeserialized);

        // ------------------------------分割线-------------------------------------
        /*
         * 1 Demo00DomainAclHandleImpl实例的Class对象序列化写入文件d://democlass.out中
         * 2 Demo00DomainAclHandleImpl类型修改名称为Demo00DomainAclHandleImplXXX
         * 3 读取d://demo.out反序列
         * 4 确认Demo00DomainAclHandleImpl类型不存在时，序列化后Demo00DomainAclHandleImpl实例的Class对象能否反序列化成功
         * 5 实验确认Demo00DomainAclHandleImpl类型不存在，序列化后Demo00DomainAclHandleImpl实例的Class对象反序列化失败，抛出异常：java.lang.ClassNotFoundException
         * */
        // serialize
//        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("d://democlass.out"));
//        Class demoClass = new Demo00DomainAclHandleImpl().getClass();
//        oout.writeObject(demoClass);
//        oout.close();

        // deserialize
//        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("d://democlass.out"));
//        Class demoClass = (Class) oin.readObject();
//        oin.close();
//        System.out.println(demoClass);
//        DomainAclHandle demoInstance = (DomainAclHandle) demoClass.newInstance();
//        System.out.println("DomainHandle code: " + demoInstance.getCode());
    }
}
