package com.java.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by xhans on 2016/3/24.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("readme.txt");
        FileChannel fcin = fin.getChannel();

        FileOutputStream fout = new FileOutputStream("writeme.txt");
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true){
            buffer.clear();
            int r = fcin.read(buffer);

            if (r == -1){
                break;
            }
            buffer.flip();
            fcout.write(buffer);
        }

    }
}
