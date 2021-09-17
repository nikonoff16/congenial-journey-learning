package io.nikonoff16;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class SerialisationExercise {
    public static void main(String[] args) throws IOException {
        System.out.println("Test");
        byte[] data = new byte[1000];
        Animal[] deserialisedAnimals = deserializeAnimalArray(data);
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] result;

        try (ObjectInputStream outputStream = new ObjectInputStream()) {
            outputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Animal) {
                return Objects.equals(name, ((Animal) o).name);
            }
            return false;
        }
    }
}

