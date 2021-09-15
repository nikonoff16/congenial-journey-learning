package javalearn.fundamentals.learnIO;

import java.io.*;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        InputStream stream;
        int result;
        stream = getStream( new byte[] { 0x33, 0x45, 0x01});

        result = checkSumOfStream(stream);
        System.out.print("Result: " + result);
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream (data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int result = 0;
        int read = inputStream.read();
        int hashSum = 0;

        while (read >= 0) {
            hashSum = (int) Integer.rotateLeft(hashSum, 1) ^ (int) read;
            // System.out.println("Temporay: " + read);
            read = inputStream.read();
        }
        
        return hashSum;
    }
}
