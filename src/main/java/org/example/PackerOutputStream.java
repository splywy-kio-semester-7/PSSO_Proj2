package org.example;

import java.io.OutputStream;

public class PackerOutputStream extends CipherOutputStream {

    public PackerOutputStream(CipherOutputStream out) {
        super(out);
    }

    public PackerOutputStream(OutputStream out) {
        super(out);
    }

    byte[] compress(String txt, int bit)
    {
        int length = txt.length();
        float tmpRet1=0,tmpRet2=0;
        if(bit==6)
        {
            tmpRet1=3.0f;
            tmpRet2=4.0f;
        }
        else if(bit==5)
        {
            tmpRet1=5.0f;
            tmpRet2=8.0f;
        }
        byte[] encoded = new byte[(int)(tmpRet1 * Math.ceil(length / tmpRet2))];
        char[] str = new char[length];
        txt.getChars(0,length,str,0);
        StringBuilder temp;
        StringBuilder strBinary = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            temp = new StringBuilder(Integer.toBinaryString(toValue(str[i])));
            while(temp.length() % bit != 0)
            {
                temp.insert(0, "0");
            }
            strBinary.append(temp);
        }
        while(strBinary.length() % 8 != 0)
        {
            strBinary.append("0");
        }
        for(int i = 0 ; i < strBinary.length(); i = i + 8)
        {
            int tempInt = Integer.valueOf(strBinary.substring(i, i + 8),2);
            encoded[i / 8] = (byte) tempInt;
        }
        return encoded;
    }

    int toValue(char ch)
    {
        int chaVal = 0;
        switch (ch) {
            case 'a' -> chaVal = 1;
            case 'b' -> chaVal = 2;
            case 'c' -> chaVal = 3;
            case 'd' -> chaVal = 4;
            case 'e' -> chaVal = 5;
            case 'f' -> chaVal = 6;
            case 'g' -> chaVal = 7;
            case 'h' -> chaVal = 8;
            case 'i' -> chaVal = 9;
            case 'j' -> chaVal = 10;
            case 'k' -> chaVal = 11;
            case 'l' -> chaVal = 12;
            case 'm' -> chaVal = 13;
            case 'n' -> chaVal = 14;
            case 'o' -> chaVal = 15;
            case 'p' -> chaVal = 16;
            case 'q' -> chaVal = 17;
            case 'r' -> chaVal = 18;
            case 's' -> chaVal = 19;
            case 't' -> chaVal = 20;
            case 'u' -> chaVal = 21;
            case 'v' -> chaVal = 22;
            case 'w' -> chaVal = 23;
            case 'x' -> chaVal = 24;
            case 'y' -> chaVal = 25;
            case 'z' -> chaVal = 26;
            case '.' -> chaVal = 27;
            case '*' -> chaVal = 28;
            case ',' -> chaVal = 29;
            case '\'' -> chaVal = 30;
            case 'A' -> chaVal = 31;
            case 'B' -> chaVal = 32;
            case 'C' -> chaVal = 33;
            case 'D' -> chaVal = 34;
            case 'E' -> chaVal = 35;
            case 'F' -> chaVal = 36;
            case 'G' -> chaVal = 37;
            case 'H' -> chaVal = 38;
            case 'I' -> chaVal = 39;
            case 'J' -> chaVal = 40;
            case 'K' -> chaVal = 41;
            case 'L' -> chaVal = 42;
            case 'M' -> chaVal = 43;
            case 'N' -> chaVal = 44;
            case 'O' -> chaVal = 45;
            case 'P' -> chaVal = 46;
            case 'Q' -> chaVal = 47;
            case 'R' -> chaVal = 48;
            case 'S' -> chaVal = 49;
            case 'T' -> chaVal = 50;
            case 'U' -> chaVal = 51;
            case 'V' -> chaVal = 52;
            case 'W' -> chaVal = 53;
            case '0' -> chaVal = 54;
            case '1' -> chaVal = 55;
            case '2' -> chaVal = 56;
            case '3' -> chaVal = 57;
            case '4' -> chaVal = 58;
            case '5' -> chaVal = 59;
            case '6' -> chaVal = 60;
            case '7' -> chaVal = 61;
            case '8' -> chaVal = 62;
            case '9' -> chaVal = 63;
            default -> {
            }
        }
        return chaVal;
    }
}
