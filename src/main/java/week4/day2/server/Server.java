package week4.day2.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {

    private int id;
    private List<String> list;

    public Server() {
        list = new ArrayList<>();
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Server is run");
                ServerSocket serverSocket = new ServerSocket(8080);
                Socket client = serverSocket.accept();

                String clientInfo = String.format("count %d, address: %s\nport: %s",
                        id++,
                client.getInetAddress(),
                        client.getPort());
                list.add(clientInfo);
                System.out.println(clientInfo);

                PrintWriter printWriter = new PrintWriter(client.getOutputStream());
                printWriter.printf("Hello, your info: %s. Current time: %s\n", clientInfo, new Date());
                printWriter.flush();
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
