package io.nikonoff16;

import java.io.*;
import java.util.Objects;

public class SerialisationExercise {
    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = {new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]);
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IOException {
        Animal[] result;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = objectInputStream.readInt();
            result = new Animal[size];

            for (int i = 0; i < size; i++) {
                result[i] = (Animal) objectInputStream.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public static class Animal implements Serializable {
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

