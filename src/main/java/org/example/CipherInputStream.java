package org.example;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CipherInputStream extends UnpackerInputStream {

    public CipherInputStream(InputStream in) {
        super(in);
    }

    public String decipher(String cipheredMessage, int[] keyStream)
    {
        byte[] decipheredMessage = new byte[cipheredMessage.length()];

        for (int i = 0; i < cipheredMessage.length(); i++)
        {
            decipheredMessage[i] = Byte.parseByte(String.valueOf((keyStream[i] ^ (int) cipheredMessage.charAt(i))));
        }
        return new String(decipheredMessage, StandardCharsets.UTF_8);
    }
}
