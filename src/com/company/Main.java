package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        //Это сервер
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String msg = null;
            while ((msg = bufferedReader.readLine())!=null){
                System.out.println(msg);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
