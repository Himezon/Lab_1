package com.lasat.client;

import java.net.UnknownHostException;

public class ClientMain {
    public static void main(String[] args) throws UnknownHostException {
        Client client = new Client();
        client.run(19735);
    }
}
