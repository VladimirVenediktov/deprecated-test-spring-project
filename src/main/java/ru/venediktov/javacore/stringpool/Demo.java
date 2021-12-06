package ru.venediktov.javacore.stringpool;

public class Demo {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "java";
        System.out.println(s1 == s1); //true потому что строки хранятся в String pool'е, и s1 и s2 указывают на одну и ту же строку из пула
        System.out.println(s1.equals(s2));

        String s3 = new String("java");//под нее принудительно выделится отдельный участок памяти, поэтому == выдаст нам false
        System.out.println(s3 == s1);
        System.out.println(s3.equals(s1));//true - у строк он переопределен и сравнивает последовательность символов в строке
    }
}
