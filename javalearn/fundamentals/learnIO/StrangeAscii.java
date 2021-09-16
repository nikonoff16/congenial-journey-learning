package javalearn.fundamentals.learnIO;

import java.io.IOException;
import java.nio.charset.*;
import java.io.Writer;
import java.io.OutputStreamWriter;

public class StrangeAscii {
    public static void main(String[] args) throws IOException {
        int byteIn = 0;
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write("Ы");
        String test = writer.;
        System.out.println(test);
    
    }
    
}
