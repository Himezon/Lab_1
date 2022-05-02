package server;

import server.commands.Command;
import server.commands.CommandController;

import java.io.*;
import java.net.*;
import java.nio.channels.ServerSocketChannel;
import java.util.Scanner;

public class Server {
    private String file;
    Server (String file) { this.file = file; }
    public void run (int port) throws IOException, ClassNotFoundException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);
        ClientReader.reader(serverSocket, file);
    }
}

