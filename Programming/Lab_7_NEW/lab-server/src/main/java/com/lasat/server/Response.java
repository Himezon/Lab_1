package com.lasat.server;

import com.lasat.common.Package;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class Response {
    public ByteBuffer serialize (Package obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        return ByteBuffer.wrap(baos.toByteArray());
    }
}
