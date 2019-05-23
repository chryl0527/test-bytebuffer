package com.sdsoon.byteBuffer;

import java.nio.ByteBuffer;

/**
 * Created By Chr on 2019/5/23.
 */
public class TestDemo5 {

    ByteBuffer byteBuffer;

    public void show() {

        this.byteBuffer = ByteBuffer.allocate(20);


        String s = "FE0A4A4E3132715067734D34374550534976099CFE";

        //需要的length
        int needSize = s.length();


        if (this.byteBuffer.remaining() < needSize) {//ByteBuffer扩容机制
            int toBeSize = needSize > 128 ? needSize : 128;
            ByteBuffer tmpBuffer = ByteBuffer.allocate(this.byteBuffer.capacity() + toBeSize);
            this.byteBuffer.flip();

//            tmpBuffer.put(this.byteBuffer);
            tmpBuffer.put(s.getBytes());

            this.byteBuffer = tmpBuffer;
        }

        System.out.println(byteBuffer);

//        this.byteBuffer.clear();


        /**
         *
         * //Exception in thread "main" java.nio.InvalidMarkException
         * 错误原因：还没有在 ByteBuffer 上执行过 mark() 方法，所以 ByteBuffer 的 mark 值还是 -1 ，所以是不能执行 reset() 方法的。
         *<p></p>
         * ByteBuffer 的 mark 属性说明：
         * 当调用 mark 方法时，会将 position 的值赋给 mark 属性，这时你可以继续读取或写入操作；
         * 当你调用 reset 方法后，会将 mark 的值赋给 position，也就是让 posistion 属性又回到了原来的位置。
         */
        this.byteBuffer.mark();
        System.out.println(this.byteBuffer);
        this.byteBuffer.reset();

        System.out.println(this.byteBuffer);


    }

    public static void main(String args[]) {


        new TestDemo5().show();
    }
}
