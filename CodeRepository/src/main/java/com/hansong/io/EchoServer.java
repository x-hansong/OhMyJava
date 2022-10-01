package com.hansong.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xhans on 2016/3/25.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);

        while (true){
            Socket clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                System.out.println("Server: " + inputLine);
                out.println(inputLine);
                if (inputLine.equals("Bye")){
                    break;
                }
            }

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
            break;
        }
    }
}
