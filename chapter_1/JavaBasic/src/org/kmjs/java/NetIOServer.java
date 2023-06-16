package org.kmjs.java;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetIOServer extends Thread{
    private ServerSocket serverSocket;

    public NetIOServer(int port) throws Exception {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                socketDialogue(socket);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void socketDialogue(Socket socket) {
        Thread thread = new Thread() {
            int count = 0;
            @Override
            public  void run() {
                try {
                    while (socket.isConnected()) {
                        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                        System.out.println("socket server receive:" + inputStream.readUTF());
                        Thread.sleep(5000);
                        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                        outputStream.writeUTF("server say hello" + count++);
                    }
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public static void main(String[] args) {
        try {
            NetIOServer server = new NetIOServer(18088);
            server.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
