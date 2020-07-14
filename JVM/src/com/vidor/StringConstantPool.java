package com.vidor;

import java.util.ArrayList;

public class StringConstantPool {
    public static void main(String[] args) {

        // intern()：取字符串常量池中的
        String s1 = new String("vidor");
        String s2 = s1.intern();
        System.out.println(s1==s2);//false
        System.out.println(s1.equals(s2));//true

        String a = "a3.4";
        String b = "a" + 3.4;
        System.out.println(a == b); // true

        String aa = "ab";
        String bb = "b";
        String c = "a" + bb; // 引用的值在程序编译期是无法确定的
        System.out.println(aa == c); // false

        String a2 = "ab";
        final String bb2 = "b";
        String b2 = "a" + bb2; // 在编译时被解析为常量值的一个本地拷贝存储到自己的常量池中或嵌入到它的字节码流中

        System.out.println(a2 == b2); // true

        String  s  =  "a" + "b" + "c";  //就等价于String s = "abc";
        String  a3  =  "a";
        String  b3  =  "b";
        String  c3 =  "c";
        String  s3  =   a  +  b  +  c;
        System.out.println(s == s3); // false
        //StringBuilder temp = new StringBuilder();
        //temp.append(a).append(b).append(c);
        //String s = temp.toString();

        String str2 = new StringBuilder("计算机").append("技术").toString();   //没有出现"计算机技术"字面量，所以不会在常量池里生成"计算机技术"对象
        System.out.println(str2 == str2.intern());  //true 字符串不存在时不再需要重新创建实例，可以直接指向堆上的实例。

        String str1 = new StringBuilder("ja").append("va").toString();    //没有出现"java"字面量，所以不会在常量池里生成"java"对象
        System.out.println(str1 == str1.intern());  //false java是关键字，在JVM初始化的相关类里肯定早就放进字符串常量池了

        String str3 = new StringBuilder("hello").append("word").toString();
        System.out.println(str3 == str3.intern()); // true

        // -Xms60M -Xmx60M -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
        // java.lang.OutOfMemoryError: GC overhead limit exceeded
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000000; i++) {
            String str = String.valueOf(i).intern();
            list.add(str);
        }
    }

}
