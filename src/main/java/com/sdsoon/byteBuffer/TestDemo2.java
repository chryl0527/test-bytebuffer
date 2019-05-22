package com.sdsoon.byteBuffer;

import java.nio.ByteBuffer;

/**
 * Created By Chr on 2019/5/22.
 */
public class TestDemo2 {
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
        byte[] bytes = s.getBytes();

        ByteBuffer byteBuffer = ByteBuffer.allocate(42 * 2);
        /*int remaining = byteBuffer.remaining();
        if (remaining >= s.length()) {
            //就不会出现:Exception in thread "main" java.nio.BufferOverflowException
        }*/
        byteBuffer.put(bytes);//
        System.out.println("第一次:" + byteBuffer);

        byteBuffer.putInt(s.length());
        System.out.println("第二次:" + byteBuffer);

    }
}
