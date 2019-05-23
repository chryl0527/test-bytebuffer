package com.sdsoon.byteBuffer;

import java.nio.ByteBuffer;

/**
 * Created By Chr on 2019/5/21.
 */
public class Demo {

    /**
     * byte[] bytes: 用来存储数据
     * int capacity: 用来表示bytes的容量，那么可以想像capacity就等于bytes.size()，此值在初始化bytes后，是不可变的。
     * int limit: 用来表示bytes实际装了多少数据，可以容易想像得到limit <= capacity，此值是可灵活变动的
     * int position: 用来表示在哪个位置开始往bytes写数据或是读数据，此值是可灵活变动的
     *
     * @param args
     */
    public static void main(String args[]) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        String s = "FE0A4A4E3132715067734D34374550534976099CFE";

        byteBuffer.put(s.getBytes());
        /**
         * flip();
         * 该方法,使读/写开始的位置从0开始,
         * 即:pos=0;lim=真是存储的数据量,cap为最大数据量
         */
        byteBuffer.flip();

        /**
         * 测试:remaining
         * remaining();
         *返回:pos和cap中间的int值
         *
         * 一般先用byteBuffer.flip():使pos=0,lim=真实数据量;
         * 再用byteBuffer.remaining():使求出pos=0和lim之间的数据量;
         * 再用byteBuffer.get(b):放到byte[]里;
         * String str = new String(b);即可
         */
        byteBuffer.position(3);
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.remaining());


        byteBuffer.position(1);
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.remaining());

        byteBuffer.position(0);
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.remaining());


        System.out.println("======================================");
        /**
         *写到byte[]里
         */
        byte[] b = new byte[byteBuffer.remaining()];

        byteBuffer.get(b);
        String s2 = new String(b);
        System.out.println(s2);

    }
}
