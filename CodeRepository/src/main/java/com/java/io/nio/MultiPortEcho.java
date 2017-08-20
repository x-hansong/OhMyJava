package com.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xhans on 2016/3/24.
 */
public class MultiPortEcho {
    private int[] ports;
    private ByteBuffer echoBuffer = ByteBuffer.allocate(5);

    public MultiPortEcho(int[] ports) throws IOException {
        this.ports = ports;

        go();
    }

    private void go() throws IOException {
        Selector selector = Selector.open();

        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ServerSocket ss = ssc.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            ss.bind(address);

            ssc.register(selector, SelectionKey.OP_ACCEPT);
        }

        while (true){
            int num = selector.select();

            System.out.println("get " + num + " events");

            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();

            while (it.hasNext()){
                SelectionKey key = (SelectionKey) it.next();

                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);

                    sc.register(selector, SelectionKey.OP_READ);
                    it.remove();
                } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ){
                    SocketChannel sc = (SocketChannel) key.channel();

                    int bytesEchoed = 0;
                    while (true){
                        echoBuffer.clear();
                        int r = sc.read(echoBuffer);

                        //当前没有可读的数据
                        if (r == 0){
                            break;
                        }
                        //对端的socket已经关闭
                        if (r == -1){
                            sc.close();
                            break;
                        }
                        echoBuffer.flip();
                        sc.write(echoBuffer);
                        bytesEchoed += r;
                    }

                    System.out.println("Echoed " + bytesEchoed + " from " + sc);
                    it.remove();
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length <= 0){
            System.err.println("Usage: java MultPortEcho port [port, port, ...]");
            System.exit(1);
        }

        int ports[] = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            ports[i] = Integer.parseInt(args[i]);
        }

        new MultiPortEcho(ports);
    }
}
