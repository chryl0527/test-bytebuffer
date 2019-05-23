package com.sdsoon.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;

/**
 * byteBuf和byteBuffer互相转化
 * <p>
 * Created By Chr on 2019/5/23.
 */
public class Demo {

    public static void main(String args[]) {

        //netty-byteBuf
        ByteBuf byteBuf = Unpooled.buffer(88);

        String s = "FE0A4A4E3132715067734D34374550534976099CFE";
        byteBuf.writeBytes(s.getBytes());

        byte[] bb = new byte[byteBuf.writerIndex()];
        byteBuf.readBytes(bb);//类似于 byteBuffer.get(b);
        String str = new String(bb);
        System.out.println(str);
        System.out.println("byteBuf:" + byteBuf);
        byteBuf.discardReadBytes();//忽略已读
        System.out.println("byteBuf:" + byteBuf);


        //#######################################################//上面已经discard已读的数据了
        byteBuf.writeBytes(s.getBytes());//再次转化
        //byteBuf->byteBuffer
        ByteBuffer byteBuffer = byteBuf.nioBuffer();
        System.out.println("byteBuffer:" + byteBuffer);
        //写到byte[]
        byte[] b = new byte[byteBuffer.remaining()];
        byteBuffer.get(b);
        String string = new String(b);
        System.out.println(string);

    }

}
