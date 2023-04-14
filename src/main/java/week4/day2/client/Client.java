package week4.day2.client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.31.230",8080);

        InputStream io = socket.getInputStream();

        BufferedReader bis = new BufferedReader(new InputStreamReader(io));

        StringBuilder sb = new StringBuilder();
        String line = null;

        while((line = bis.readLine()) != null){
            System.out.println(line);
            sb.append(line).append("\n");
        }

    }
}
