package com.hansong.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by xhans on 2016/3/25.
 */
public class TimeClient {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        final AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<Void> future = client.connect(new InetSocketAddress("127.0.0.1", 1234));
        future.get();

        final ByteBuffer buffer = ByteBuffer.allocate(100);
        client.read(buffer, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("client received: " + new String(buffer.array()));
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

//        Thread.sleep(10000);
    }
}
