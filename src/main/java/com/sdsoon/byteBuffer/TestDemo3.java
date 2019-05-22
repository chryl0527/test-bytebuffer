package com.sdsoon.byteBuffer;

import java.nio.ByteBuffer;

/**
 * Created By Chr on 2019/5/22.
 */
public class TestDemo3 {
    /**
     * 当 ByteBuffer.remaining()  小于要读取或写入的长度时，再执行读取或写入操作都会产生异常；
     * <p>
     * 读取则产生 java.nio.BufferUnderflowException 异常，
     * <p>
     * 写入则产生 java.nio.BufferOverflowException 异常。
     * <p>
     * 当 ByteBuffer.remaining()  等于 0 时，不能再执行读取或写入操作，需要执行：clear() 操作，否则将产生异常。
     *
     * @param args
     */
    public static void main(String args[]) {

        show();
//        show2();
    }

    public static void show2() {
        String s = "FE";
        byte[] bytes = s.getBytes();

        ByteBuffer byteBuffer = ByteBuffer.allocate(42 * 2);

        byteBuffer.put(bytes);//先进性put
        int remaining = byteBuffer.remaining();

        System.out.println(byteBuffer);
    }


    public static void show() {
        String s = "FE0A4A4E3132715067734D34374550534976099CFE";
        byte[] bytes = s.getBytes();
        char[] chars = s.toCharArray();
        //s的长度
        System.out.println(chars.length);
        //String->char[]->byte[]
        String s1;
//        String s2 = null;//莫名其妙:null竟然那是4个长度的字符,只好改成""
        String s2 = "";

        for (char c : chars) {
            s1 = String.valueOf(c);
            s2 += s1;
        }

        System.out.println(bytes.length);
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();

        //####################下面开始用reaming测试putInt##########################//
//        ByteBuffer byteBuffer = ByteBuffer.allocate(42);
        ByteBuffer byteBuffer = ByteBuffer.allocate(42 * 2);

        byteBuffer.put(bytes);//先进性put

        System.out.println("第一次:" + byteBuffer);
        int i = 0;
        while (byteBuffer.remaining() > 0) {
//            byteBuffer.putInt(1);//4
//            byteBuffer.putChar((char) 1);//2
//            byteBuffer.putLong(3L);//8


            byteBuffer.put((byte) chars[i]);

            i++;
        }

        System.out.println("第二次:" + byteBuffer);
    }
}
