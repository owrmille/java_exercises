import java.io.*;
import java.util.Objects;

public class SerializationPractice {
    public static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }

        @Override
        public String toString() {
            return "Animal name: " + name; 
        }

        public static Animal[] deserializeAnimalArray(byte[] byteData) {
            try {
                int arraySize;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteData);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                arraySize = objectInputStream.readInt();
            
                Animal[] animalData = new Animal[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    try {
                        animalData[i] = (Animal) objectInputStream.readObject();
                    } catch (IllegalArgumentException e) {
                        throw e;
                    }
                }
                return animalData;
            } catch (IOException | ClassNotFoundException | ClassCastException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) throws IOException {      
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant")};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);              
        objectOutputStream.writeInt(animalM1.length);
        for (Animal animal : animalM1) {              
            objectOutputStream.writeObject(animal);
        }      
        objectOutputStream.flush();
        objectOutputStream.close();
        Animal[] animalM2 = Animal.deserializeAnimalArray(byteArrayOutputStream.toByteArray());
        for (Animal animal : animalM2) {              
            System.out.println(animal.toString());
        } 
    }
}
