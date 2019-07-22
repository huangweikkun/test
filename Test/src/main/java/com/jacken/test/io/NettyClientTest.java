package com.jacken.test.io;

import com.sun.java.swing.plaf.windows.WindowsRadioButtonMenuItemUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author jacken
 * @date 2017/11/29
 */
public class NettyClientTest {

    public static void main(String[] args) {
        Integer serverPort = 8080;
        try {
            Socket socket = new Socket("127.0.0.1", serverPort);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("this is a message client send to the server");
            String resp = bufferedReader.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
