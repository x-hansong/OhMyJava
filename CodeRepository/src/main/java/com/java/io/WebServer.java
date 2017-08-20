package com.java.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * Created by xhans on 2016/3/25.
 */
public class WebServer extends Thread {
   protected Socket clientSocket;

    private WebServer(Socket socket){
        this.clientSocket = socket;
        start();
    }

    @Override
    public void run() {
        String requestMessageLine;
        String fileName;

        BufferedReader inFromClient = null;
        try {
            inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

            requestMessageLine = inFromClient.readLine();
            StringTokenizer tokenizerLine = new StringTokenizer(requestMessageLine);

        if (tokenizerLine.nextToken().equals("GET")){
            fileName = tokenizerLine.nextToken();

            if (fileName.startsWith("/") == true){
                fileName = fileName.substring(1);
            }

            File file = new File(fileName);

            if (file.exists()){
                int numOfBytes = (int) file.length();
                FileInputStream inFile = new FileInputStream(fileName);

                byte[] fileInBytes = new byte[numOfBytes];
                inFile.read(fileInBytes);

                outToClient.writeBytes("HTTP/1.0 200 Document Follows\r\n");
                if (fileName.endsWith(".jpg")){
                    outToClient.writeBytes("Content-Type: image/jpeg\r\n");
                } else if (fileName.endsWith(".gif")){
                    outToClient.writeBytes("Content-Type: image/gif\r\n");
                }

                outToClient.writeBytes("Content-Length: " + numOfBytes + "\r\n");
                outToClient.writeBytes("\r\n");

                outToClient.write(fileInBytes, 0, numOfBytes);

                requestMessageLine = inFromClient.readLine();
                while (requestMessageLine.length() >= 5){
                    System.out.println("Request: " + requestMessageLine);
                    requestMessageLine = inFromClient.readLine();
                }
                System.out.println("Request: " + requestMessageLine);

                clientSocket.close();
            } else {
                outToClient.writeBytes("HTTP/1.0 404 Not Found\r\n");
            }
        } else {
            System.out.println("Bad Request Message");
        }
                    } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {

        int myPort = 1234;

        if (args.length > 0){
            myPort = Integer.parseInt(args[0]);
        }

        ServerSocket listenSock = new ServerSocket(myPort);

        while (true){
            new WebServer(listenSock.accept());
        }

    }

}
