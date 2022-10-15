package org.example;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class UnpackerInputStream extends FilterInputStream {

    public UnpackerInputStream(InputStream in) {
        super(in);
    }

    String decompress(byte[] encoded, int bit)
    {
        StringBuilder strTemp;
        StringBuilder strBinary = new StringBuilder();
        StringBuilder strText = new StringBuilder();
        int tempInt;
        int intTemp;
        for (byte b : encoded)
        {
            if (b < 0)
            {
                intTemp = (int) b + 256;
            }
            else
            {
                intTemp = b;
            }
            strTemp = new StringBuilder(Integer.toBinaryString(intTemp));
            while (strTemp.length() % 8 != 0)
            {
                strTemp.insert(0, "0");
            }
            strBinary.append(strTemp);
        }
        for (int i = 0; i < strBinary.length(); i = i + bit)
        {
            tempInt = Integer.valueOf(strBinary.substring(i, i + bit),2);
            strText.append(toChar(tempInt));
        }
        return scuffedToString(strText.toString());
    }

    public String scuffedToString(String text)
    {
        StringBuilder result = new StringBuilder();
        String[] textTab = text.replace(" ", "").split(",");
        List<String> textList = new ArrayList<>(Arrays.asList(textTab));

        textList.stream()
                .flatMapToInt(string -> IntStream.of(Integer.parseInt(string)))
                .boxed()
                .toList()
                .forEach(i -> result.append(Character.toString(i)));

        return result.toString();
    }

    char toChar(int val){
        char ch = ' ';
        switch (val) {
            case 1 -> ch = 'a';
            case 2 -> ch = 'b';
            case 3 -> ch = 'c';
            case 4 -> ch = 'd';
            case 5 -> ch = 'e';
            case 6 -> ch = 'f';
            case 7 -> ch = 'g';
            case 8 -> ch = 'h';
            case 9 -> ch = 'i';
            case 10 -> ch = 'j';
            case 11 -> ch = 'k';
            case 12 -> ch = 'l';
            case 13 -> ch = 'm';
            case 14 -> ch = 'n';
            case 15 -> ch = 'o';
            case 16 -> ch = 'p';
            case 17 -> ch = 'q';
            case 18 -> ch = 'r';
            case 19 -> ch = 's';
            case 20 -> ch = 't';
            case 21 -> ch = 'u';
            case 22 -> ch = 'v';
            case 23 -> ch = 'w';
            case 24 -> ch = 'x';
            case 25 -> ch = 'y';
            case 26 -> ch = 'z';
            case 27 -> ch = '.';
            case 28 -> ch = '*';
            case 29 -> ch = ',';
            case 30 -> ch = '\'';
            case 31 -> ch = 'A';
            case 32 -> ch = 'B';
            case 33 -> ch = 'C';
            case 34 -> ch = 'D';
            case 35 -> ch = 'E';
            case 36 -> ch = 'F';
            case 37 -> ch = 'G';
            case 38 -> ch = 'H';
            case 39 -> ch = 'I';
            case 40 -> ch = 'J';
            case 41 -> ch = 'K';
            case 42 -> ch = 'L';
            case 43 -> ch = 'M';
            case 44 -> ch = 'N';
            case 45 -> ch = 'O';
            case 46 -> ch = 'P';
            case 47 -> ch = 'Q';
            case 48 -> ch = 'R';
            case 49 -> ch = 'S';
            case 50 -> ch = 'T';
            case 51 -> ch = 'U';
            case 52 -> ch = 'V';
            case 53 -> ch = 'W';
            case 54 -> ch = '0';
            case 55 -> ch = '1';
            case 56 -> ch = '2';
            case 57 -> ch = '3';
            case 58 -> ch = '4';
            case 59 -> ch = '5';
            case 60 -> ch = '6';
            case 61 -> ch = '7';
            case 62 -> ch = '8';
            case 63 -> ch = '9';
            default -> {
            }
        }
        return ch;
    }
}
