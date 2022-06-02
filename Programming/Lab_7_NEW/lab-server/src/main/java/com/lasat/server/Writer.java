package com.lasat.server;

import com.lasat.server.commands.CommandController;
import com.lasat.common.Package;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class Writer implements Runnable {

    SocketChannel client;
    Package outputPack;

    public Writer (SocketChannel client, Package outputPack) {
        this.client = client;
        this.outputPack = outputPack;
    }

    @Override
    public void run() {
        Response response = new Response();
        try {
            client.write(response.serialize(outputPack));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
