package caesaralgorithm;

import java.util.*;
import java.io.*;

public class CaesarAlgorithms {
    Scanner in = new Scanner(System.in);
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int alphabetsize = ALPHABET.length();
    private String originalText;
    private int shift;
    private char symbol;
    private char ch;
    private String test;

    public int getShift() {
        return shift;
    }

    public int shiftsize(int shift) {
        if (shift > alphabetsize) {
            shift %= alphabetsize;
        }
        while (shift < 0) {
            shift += alphabetsize;
        }
        return shift;
    }

    public void input() {
        System.out.println("Enter the string to be encrypted");
        originalText = in.nextLine();
        do {
            System.out.println("enter the positive number by which the shift should be made");
            shift = in.nextInt();
        } while (shift < 0);
        shift = shiftsize(shift);
    }

    public String shiftLeftOrRigth() {
        System.out.println("do you want to shift right or left or decription pleas enter r/l");
        test = in.next();
        String encription;
        if (test.equalsIgnoreCase("r")) {
            encription = encryptionRigthSHift(originalText, shift);
            return encription;
        }
        encription = enencryptionLeftSHift(originalText, shift);
        return encription;
    }

    public String enencryptionLeftSHift(String originalText, int shift) {
        String encryption = "";
        for (int i = 0; i < originalText.length(); i++) {
            symbol = originalText.charAt(i);
            ch = (char) (symbol - shift);
            if (ch < 97) {
                encryption = encryption + (char) (ch + alphabetsize);
            } else {
                encryption += ch;
            }
        }
        return encryption;
    }

    public String encryptionRigthSHift(String originalText, int shift) {
        String encryption = "";
        for (int i = 0; i < originalText.length(); i++) {
            symbol = originalText.charAt(i);
            ch = (char) (symbol + shift);
            if (Character.isUpperCase(symbol) && ch > 90) {
                encryption = encryption + (char) (ch - alphabetsize);
            } else if (Character.isLowerCase(symbol) && ch > 122) {
                encryption = encryption + (char) (ch - alphabetsize);
            } else {
                encryption += ch;
            }
        }
        return encryption;
    }

    public String decryption(String encryptionText, int shift) {
        String decryption = "";
        for (int i = 0; i < encryptionText.length(); i++) {
            symbol = encryptionText.charAt(i);
            if (test.equalsIgnoreCase("r")) {
                ch = (char) (symbol - shift);
                if (ch < 97) {
                    ch += alphabetsize;
                }
            } else {
                ch = (char) (symbol + shift);
                if (ch > 122) {
                    ch = (char) (ch - alphabetsize);
                }
            }
            decryption = decryption + ch;
        }
                return decryption;
    }

    public void filrcreat(File myfile) {
        String str = shiftLeftOrRigth();
        BufferedReader reader = null;
        try {
            PrintWriter writer = new PrintWriter(myfile);
            writer.println("this is original text " + originalText);
            writer.println("this is ecription text : " + str);
            writer.println("this is description text " + decryption(str, shift));
            writer.close();
            reader = new BufferedReader(new FileReader(myfile));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println("error");
        }
        try {
            reader.close();
        } catch (Exception ex) {
            System.out.println("error");
        }
    }
}
