package com.company;

import java.io.BufferedReader;
import java.io.IOException;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 17.04.2017
 * 
 * Karpikova
 */
public class Reader implements Runnable{
    private BufferedReader bufferedReader;

    public Reader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    @Override
    public void run() {
        String his_msg = "";
        while (his_msg!="stopit")
        {
            try {
                if ((his_msg = bufferedReader.readLine())!=null){
                    System.out.println(his_msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
