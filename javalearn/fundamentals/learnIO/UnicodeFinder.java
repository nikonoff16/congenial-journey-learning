package javalearn.fundamentals.learnIO;

import java.io.IOException;
import java.nio.charset.*;
import java.util.Arrays;

public class UnicodeFinder {
    public static void main(String[] args) throws IOException{
       
        Charset charset = StandardCharsets.UTF_8;
        byte [] b = "Ы".getBytes(charset);
        int [] result = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            result [i] = Byte.toUnsignedInt(b [i]);
        }
        System.out.print(Arrays.toString(result));
    }
}
