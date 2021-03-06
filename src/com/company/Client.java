package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 17.04.2017
 * 
 * Karpikova
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("I'm a client");
        try {
            Socket socket = new Socket("localhost", 5555);
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