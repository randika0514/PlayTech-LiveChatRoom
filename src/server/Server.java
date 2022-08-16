package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static ArrayList<ClientHandler> clientHandlers=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(5000);
        Socket accept;

        while (true){

            System.out.println("Server start...");
            accept= serverSocket.accept();
            System.out.println("Client Connected...");
            ClientHandler clientHandler = new ClientHandler(accept, clientHandlers);
            clientHandlers.add(clientHandler);
            clientHandler.start();
        }

    }
}
