package org.example;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        /*InputStream inputStream;
        byte[] compressed, ciphered;
        String decompressed, deciphered;
        CipherOutputStream cipherOutputStream;

        try {
            inputStream = new FileInputStream("src/main/resources/plainText.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            PackerOutputStream packerOutputStream = new PackerOutputStream( new FileOutputStream("src/main/resources/compressedText.txt") );
            try {
                compressed = packerOutputStream.compress(Arrays.toString(inputStream.readAllBytes()), 6);
                packerOutputStream.write(compressed);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            UnpackerInputStream unpackerInputStream = new UnpackerInputStream( new FileInputStream("src/main/resources/compressedText.txt") );
            try {
                decompressed = unpackerInputStream.decompress(unpackerInputStream.readAllBytes(), 6);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(decompressed);

        try {
            cipherOutputStream = new CipherOutputStream( new FileOutputStream("src/main/resources/plainText2.txt") );
            ciphered = cipherOutputStream.cipher("Jebac Doktora Dziubicha", "key");
            try {
                cipherOutputStream.write(ciphered);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            CipherInputStream cipherInputStream = new CipherInputStream( new FileInputStream("src/main/resources/plainText2.txt") );
            System.out.println(cipherInputStream.decipher(cipherOutputStream.getKeyStream()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/

        // MERGE
        try {
            PackerOutputStream outputStream1 = new PackerOutputStream( new CipherOutputStream( new FileOutputStream("src/main/resources/compressedAndCiphered.txt") ) );
            CipherInputStream inputStream1 = new CipherInputStream( new UnpackerInputStream( new FileInputStream("src/main/resources/compressedAndCiphered.txt") ) );
            try {
                outputStream1.write(outputStream1.compress(Arrays.toString(outputStream1.cipher("Jebac Doktora Dziubicha", "key")), 6));
                String result = inputStream1.decipher(inputStream1.decompress(inputStream1.readAllBytes(), 6), outputStream1.getKeyStream());
                System.out.println(result);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}