package org.example;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class CipherOutputStream extends FilterOutputStream {

    private static final int KEY_LENGTH = 256;
    private static final String DEFAULT_KEY = ("knbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57dekn" +
            "bfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57de" +
            "knbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57deknbfyt57delnb43a");

    private int[] sBox = new int[256];

    private String kBox = "";

    private int[] keyStream;

    public CipherOutputStream(OutputStream out)
    {
        super(out);
        init();
    }

    public CipherOutputStream(PackerOutputStream out)
    {
        super(out);
        init();
    }

    public void init()
    {
        for (int i = 0; i < KEY_LENGTH; i++)
        {
            sBox[i] = i;
        }
    }

    public byte[] cipher(String message, String key)
    {
        if (key == null)
        {
            kBox = DEFAULT_KEY;
        }
        else
        {
            for (int i = 0; i < 256; i++)
            {
                kBox += key.charAt(i % key.length());
            }
        }
        scrambling();
        keyStream = generateKeyStream(message);

        byte[] cipheredMessage = new byte[message.length()];

        for (int i = 0; i < message.length(); i++)
        {
            cipheredMessage[i] = (byte) ((int) message.charAt(i) ^ keyStream[i]);
        }
        //System.out.println(message);
        return cipheredMessage;
    }

    private int[] generateKeyStream(String message)
    {
        keyStream = new int[message.length()];
        int i = 0;
        int j = 0;
        for (int k = 0; k < message.length(); k++)
        {
            i = (i + 1) % 256;
            j = (j + 1) % 256;
            swapIntTab(sBox, i, j);
            keyStream[k] = sBox[(sBox[i] + sBox[j]) % 256] % 128;
        }

        return keyStream;
    }

    private void scrambling()
    {
        int x = 0;
        int temp;
        for (int i = 0; i < 256; i++)
        {
            x = (x + sBox[i] + kBox.charAt(i)) % KEY_LENGTH;
            swapIntTab(sBox, i, x);
        }
    }

    private void swapIntTab(int[] tab, int x, int y)
    {
        int temp = tab[x];
        tab[x] = tab[y];
        tab[y] = temp;
    }

    public int[] getKeyStream()
    {
        return keyStream;
    }
}
