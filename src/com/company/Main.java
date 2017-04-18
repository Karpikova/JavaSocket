package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Это сервер
        System.out.println("I'm a server");
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            Socket socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            Reader reader = new Reader(bufferedReader);
            Thread readerThread = new Thread(reader);
            readerThread.start();

            Writer writer = new Writer(bufferedWriter);
            Thread writerThread = new Thread(writer);
            writerThread.start();

            readerThread.join();
            writerThread.join();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
