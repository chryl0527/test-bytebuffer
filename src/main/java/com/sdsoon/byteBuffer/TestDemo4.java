package com.sdsoon.byteBuffer;

import java.nio.ByteBuffer;

/**
 * Created By Chr on 2019/5/22.
 */
public class TestDemo4 {
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
        String s = "FE0A4A4E3132715067734D34374550534976099CFE";
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
        byte[] bytes1 = s2.getBytes();
        System.out.println(bytes1.length);
        for (byte b : bytes1) {
            System.out.print(b + " ");
        }
        System.out.println();
        //String->byte[]
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
        for (byte b : bytes1) {
            System.out.print(b + " ");
        }
        System.out.println();
        //####################下面开始用reaming测试putInt##########################//
//        ByteBuffer byteBuffer = ByteBuffer.allocate(42);
        ByteBuffer byteBuffer = ByteBuffer.allocate(42 * 2);

        byteBuffer.put(bytes);//

        int i = 0;
        while (byteBuffer.remaining() > 0) {
//            byteBuffer.put((byte) 0);
            byteBuffer.putInt(bytes[i]);

            i++;
        }

//        byteBuffer.putInt(s.length());
        System.out.println(bytes);
    }
}
