package org.example;

import java.io.FilterInputStream;
import java.io.InputStream;

public class CipherInputStream extends FilterInputStream {

    public CipherInputStream(InputStream in) {
        super(in);
    }


}
