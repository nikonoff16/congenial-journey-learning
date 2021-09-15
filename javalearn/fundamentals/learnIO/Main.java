package javalearn.fundamentals.learnIO;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream( new byte[] { 0x65, 0x13, 0x10, 0x10, 0x13 });
        System.setIn(inputStream);

        int read = System.in.read();
        int next;

        while (read >= 0) {
            
            if (read == 13) {
                next = System.in.read();
                if (read != 10) {
                    // buffer[count] = 0x13;
                    System.out.write(read);
                    // count++;
                }
            }
            
            if (read != -0x1)
                // buffer[count] = (byte) read;
                System.out.write(read);
                // count++;
            
            read = System.in.read();
        }


        System.out.flush();
    }
}