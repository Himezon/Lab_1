package com.lasat.server;

import com.lasat.common.Package;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;

public class RequestHandler {
    public Package deserialize (ByteBuffer buffer) throws IOException, ClassNotFoundException {
        byte[] array = new byte[buffer.remaining()];
        buffer.get(array);
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        ObjectInputStream objectInputStream = new ObjectInputStream(bais);
        return (Package) objectInputStream.readObject();
    }
}
