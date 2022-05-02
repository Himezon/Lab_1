package server;

import server.commands.CommandController;
import server.data.Person;
import server.dataController.DataController;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ClientReader {

    public static void reader(ServerSocketChannel serverSocket, String file) throws IOException, ClassNotFoundException {
        DataController dataController = new DataController(file);
        Selector selector = Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(32768);

        while (true) {
            selector.select();
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();
                if (!key.isValid()) continue;
                if (key.isAcceptable()) accept(selector, serverSocket);
                if (key.isReadable()) read(key, buffer, dataController);
            }
        }
    }
    public static void accept (Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel channel = serverSocket.accept();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
    }

    public static void read (SelectionKey key, ByteBuffer buffer, DataController dataController) throws IOException, ClassNotFoundException {
        RequestHandler requestHandler = new RequestHandler();
        Response response = new Response();
        SocketChannel client = (SocketChannel) key.channel();
        CommandController commandController = new CommandController("");
        int num = client.read(buffer);
        if (num == -1) {
            client.close();
            System.out.println("Client disable");
        } else {
            buffer.flip();
            Object obj = requestHandler.deserialize(buffer);
            String[] command;
            if (obj instanceof String[]) {
                command = (String[]) obj;
                client.write(response.serialize(commandController.invoke(commandController.parseCommand(command[0]), command)));
            } else if (obj instanceof Person) {
                dataController.addPerson((Person) obj);
                command = new String[] {"insert"};
                client.write(response.serialize(commandController.invoke(commandController.parseCommand(command[0]), command)));
            }
            buffer.clear();
        }


    }

}
