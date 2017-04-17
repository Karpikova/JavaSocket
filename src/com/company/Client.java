package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

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
        try {
            Socket socket = new Socket("localhost", 5555);
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            bufferedWriter.write("Hello, it's me");
            bufferedWriter.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
