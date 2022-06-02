package com.lasat.server;

import com.lasat.common.Package;
import com.lasat.server.commands.CommandController;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ClientReader extends Thread {

    private static int counter;
    private static final ForkJoinPool forkJoinPool = new ForkJoinPool((int) (Runtime.getRuntime().availableProcessors() * 0.5 * (1 + 10)));
    private static final int THREADS = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

    public static void reader(ServerSocketChannel serverSocket, String file) {
        try {
            CommandController commandController = new CommandController(file);
            System.out.println("Поиск нового подключения...");
            counter += 1;
            Selector selector = Selector.open();
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            ByteBuffer buffer = ByteBuffer.allocate(32768);
            while (true) {
                try {
                    selector.select();
                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove();
                        if (!key.isValid()) continue;
                        if (key.isAcceptable()) accept(selector, serverSocket);
                        if (key.isReadable())
                            CompletableFuture.supplyAsync(() -> Reader.read(key, buffer, commandController),
                                            forkJoinPool)
                                    .thenAcceptAsync((pack) -> new Processor(commandController, (SocketChannel) key.channel()
                                    ).process(pack), executorService);
                    }
                } catch (IOException e) {
                    System.out.println("Клиент №" + counter + " отключён");
                    reader(serverSocket, file);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка во время подключения...");
        }
    }

    public static void accept(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel channel = serverSocket.accept();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        System.out.println("Новое подключение...");
    }
}
