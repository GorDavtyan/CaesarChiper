package caesaralgorithm;

import java.io.*;

public class CaesarAlgorithmsMain {
    public static void main(String[] args) {
        CaesarAlgorithms caesar = new CaesarAlgorithms();
        caesar.input();
        caesar.shiftsize(caesar.getShift());
        String path = "/home/gor/Desktop/myfile.txt";
        File myfile = new File(path);
        caesar.filrcreat(myfile);
    }
}
