package org.kmjs.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class NetIOClient {
    public static void main(String[] args) {
        int count = 0;
        try {
            Socket socket = new Socket("127.0.0.1", 18088);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("client say hello");
            while (socket.isConnected()) {
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                System.out.println("socket client receive: " + inputStream.readUTF());
                Thread.sleep(5000);
                outputStream.writeUTF("client say hello" + count++);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
