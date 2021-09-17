package io.nikonoff16;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SerialisationDemo {
    public static void main(String[] args) throws IOException {
        Client originalClient = new Client();
        originalClient.setId(1);
        originalClient.setName("Joseph Nikonoff");
        originalClient.setBirthDate(LocalDate.of(1990, 2, 1));

        Path path = Paths.get("object.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(originalClient);
        }

        Client deserializedClient = new Client();
        try (ObjectInputStream ois = new ObjectInputStream((Files.newInputStream(path)))) {
            deserializedClient = (Client) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(deserializedClient.getId());
        System.out.println(deserializedClient.getName());
        System.out.println(deserializedClient.getBirthDate());
        System.out.println(deserializedClient.getAgeInYears());

    }

    public static class Client implements Serializable {
        private long id;
        private String name;
        private LocalDate birthDate;
        private transient int ageInYears;


        public void setId(long id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }
        public long getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public LocalDate getBirthDate() {
            return birthDate;
        }
        public int getAgeInYears() {
            if (ageInYears == 0) {
                ageInYears = birthDate.until(LocalDate.now()).getYears();
            }
            return ageInYears;
        }
    }
}
