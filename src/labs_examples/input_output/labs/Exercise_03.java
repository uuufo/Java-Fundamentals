package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 3: variety
 *
 *    1) Demonstrate the usage of at least two additional Byte Streams
 *    2) Demonstrate the usage of at least two additional Character Streams
 *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams
 *    4) Demonstrate the use of the DataInputStream and DataOutputStream
 *
 */

class Exercise_03 {
    public static void main(String[] args) {

        Exercise_03 exercise_03 = new Exercise_03();
        exercise_03.objectByteStream();
        exercise_03.dataByteStream();

    }

    public void objectByteStream() {
        String objFile = "src/labs_examples/input_output/files/user.dat";
        Person person1 = new Person("Jared", 36);
        Person person2 = null;

        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(objFile))) {
            objectOut.writeObject(person1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(objFile))) {
            person2 = (Person) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(person1.toString());
        System.out.println(person2.toString());
    }

    public void dataByteStream() {
        String dataFile = "src/labs_examples/input_output/files/data.bin";
        boolean[] b = {false, true, false};

        try(DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(dataFile))) {
            for (boolean value : b) {
                dataOut.writeBoolean(!value);  // invert when we write to file to verify they are being read
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(DataInputStream dataIn = new DataInputStream(new FileInputStream(dataFile))) {
            for (int i = 0; i < b.length; i++) {
                b[i] = dataIn.readBoolean();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (boolean value : b) {
            System.out.println(value);
        }
    }

    public void twoCharStreams() {

    }

    public void dataStreams() {

    }

    public static class Person implements Serializable {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}