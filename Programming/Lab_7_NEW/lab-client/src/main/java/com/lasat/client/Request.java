package com.lasat.client;

import com.lasat.common.Package;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Request {

    public void request(Package obj, Socket socket) throws IOException {
        socket.getOutputStream().write(serialize(obj).toByteArray());
        socket.getOutputStream().flush();
    }
    public ByteArrayOutputStream serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        return byteArrayOutputStream;
    }
}
