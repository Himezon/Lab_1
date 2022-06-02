package com.lasat.server;

import com.lasat.common.Package;
import com.lasat.server.commands.CommandController;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class Reader {
    SelectionKey key;
    ByteBuffer byteBuffer;
    CommandController commandController;

    public Reader (ByteBuffer byteBuffer, SelectionKey key, CommandController commandController) {
        this.byteBuffer = byteBuffer;
        this.key = key;
        this.commandController = commandController;
    }

    public static Package read(SelectionKey key, ByteBuffer buffer, CommandController commandController) {
        RequestHandler requestHandler = new RequestHandler();
        SocketChannel client = (SocketChannel) key.channel();
        try {
            int num = client.read(buffer);
            if (num == -1) {
                client.close();
                System.out.println("Client disable");
                return null;
            } else {
                buffer.flip();
                Package obj = requestHandler.deserialize(buffer);
                buffer.clear();
                return obj;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
