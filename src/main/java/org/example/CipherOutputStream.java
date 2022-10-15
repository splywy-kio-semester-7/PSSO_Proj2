package org.example;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class CipherOutputStream extends FilterOutputStream {

    public CipherOutputStream(OutputStream out) {
        super(out);
    }
}
