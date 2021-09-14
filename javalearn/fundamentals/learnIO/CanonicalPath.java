package javalearn.fundamentals.learnIO;

import java.io.IOException;
import java.nio.file.*;

public class CanonicalPath {
    public static void main(String[] args) {
        String[] paths = {".\\a\\b\\..\\b\\c\\.\\file.txt", "a\\..\\b\\c\\file.txt", "a\\b\\c\\file.txt", "a\\b\\..\\file.txt", "a\\.\\b\\..\\c\\.\\file.txt"};

        for (String path : paths) {
            Path realPath = Paths.get(path);
            try {
                String canonicalPath = realPath.toFile().getCanonicalPath();
                System.out.println(canonicalPath);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
}
