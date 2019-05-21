package com.sdsoon.byteBuffer;

import java.nio.ByteBuffer;

/**
 * byte[] bytes: 用来存储数据:
 * int capacity: 用来表示bytes的容量，那么可以想像capacity就等于bytes.size()，此值在初始化bytes后，是不可变的。
 * int limit: 用来表示bytes实际装了多少数据，可以容易想像得到limit <= capacity，此值是可灵活变动的
 * int position: 用来表示在哪个位置开始往bytes写数据或是读数据，此值是可灵活变动的
 * <p>
 * Created By Chr on 2019/5/21.
 */
public class TestDemo {


    /**
     * lim:实际装了多少数据,pos:读/写开始的位置,cap最大容量
     * <p>
     * byteBuffer:
     * put:pos移动,lim和cap不变
     * 可以手动设置pos的位置和lim的的小
     *
     * @param args
     */
    public static void main(String args[]) {


        ByteBuffer byteBuffer = ByteBuffer.allocate(10);//java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]
        byteBuffer.put((byte) 3);//java.nio.HeapByteBuffer[pos=1 lim=10 cap=10]
        byteBuffer.put((byte) 5);//java.nio.HeapByteBuffer[pos=2 lim=10 cap=10]

        System.out.println(byteBuffer);//java.nio.HeapByteBuffer[pos=2 lim=10 cap=10]

        //设置position到0位置，这样读数据时就从这个位置开始读
        byteBuffer.position(0);//java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]
        //设置limit为1，表示当前bytebuffer的有效数据长度是1
        byteBuffer.limit(1);//java.nio.HeapByteBuffer[pos=0 lim=1 cap=10]
        System.out.println(byteBuffer);//java.nio.HeapByteBuffer[pos=0 lim=1 cap=10]

        //调用ByteBuffer.get()即可读取一个字节，在读取数据的同时，ByteBuffer的position也会跟关位移
        byte b = byteBuffer.get();//java.nio.HeapByteBuffer[pos=1 lim=1 cap=10]
        System.out.println(byteBuffer);//java.nio.HeapByteBuffer[pos=1 lim=1 cap=10]
    }
}
