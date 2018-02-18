package com.jacken.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jacken
 * @date 2017/11/29
 */
public class NettyServerTest {

    public static void main(String[] args) throws IOException {
        Integer port = 8080;
        if(args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        ServerSocket serverSocket = null;
        try {
            serverSocket  = new ServerSocket(port);
            System.out.println("server bind port:" + port);
            Socket socket;
            while (true){
                socket = serverSocket.accept();
                new Thread(new NettyServerTest().new SocketHandler(socket)).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null) {
                System.out.println("server socket close");
                serverSocket.close();
                serverSocket = null;
            }
        }

    }

    class SocketHandler implements Runnable {

        private Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter printWriter = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printWriter = new PrintWriter(socket.getOutputStream(), true);
                String request = "";
                while (true) {
                    request = reader.readLine();
                    if (request == null) {
                        break;
                    }

                    System.out.println("receive request:" + request);
                    printWriter.println("test");
                }
            } catch (IOException e) {
                if(reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

                if(printWriter != null) {
                    printWriter.close();
                }

                e.printStackTrace();
            }
        }
    }
}
