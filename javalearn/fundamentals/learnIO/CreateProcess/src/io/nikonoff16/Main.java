package io.nikonoff16;

import java.io.*;
import java.lang.ProcessBuilder.Redirect;

public class Main {

    public static void main(String[] args) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd.exe")
                .directory(new File("C:\\Users\\osipov\\vscode-proj\\congenial-journey-learning"))
                .redirectOutput(Redirect.PIPE)
                .redirectError(Redirect.INHERIT);

        Process process = processBuilder.start();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        )) {
            reader.lines().forEach(System.out::println);
        }

        int exitValue = process.waitFor();
        if (exitValue != 0) {
            System.err.println("Subprocess fucked up");
        }
    }
}
