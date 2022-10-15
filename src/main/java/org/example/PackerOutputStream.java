package org.example;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class PackerOutputStream extends FilterOutputStream {

    public PackerOutputStream(OutputStream out) {
        super(out);
    }


}
