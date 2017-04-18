package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
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
public class Writer implements Runnable {
    private BufferedWriter bufferedWriter;

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public Writer(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void run() {
        String my_msg = "";
        Scanner in = new Scanner(System.in);

        while (my_msg!="stopit")
        {
            if ((my_msg = in.nextLine())!=null) {
                try {
                    bufferedWriter.write(my_msg + "\n");
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
