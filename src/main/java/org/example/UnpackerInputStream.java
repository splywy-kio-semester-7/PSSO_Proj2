package org.example;

import java.io.FilterInputStream;
import java.io.InputStream;

public class UnpackerInputStream extends FilterInputStream {

    public UnpackerInputStream(InputStream in) {
        super(in);
    }


}
