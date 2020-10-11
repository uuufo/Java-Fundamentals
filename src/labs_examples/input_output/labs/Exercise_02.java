package labs_examples.input_output.labs;

import java.io.*;
import java.util.Scanner;

/**
 * Input/Output Exercise 2: File encryption
 *
 *      -Using the BufferedReader, read a file character by character and write an encrypted version to a new file.
 *      -For example, change every 'a' to '-' and every 'e' to '~' .
 *      -Make sure you close the connections to both files.
 *
 *      Then, read back the encrypted file using the BufferedReader and
 *      print out the unencrypted version. Does it match the original file?
 *
 */

class Exercise_02 {
    public static void main(String[] args) {

        Exercise_02 exercise_02 = new Exercise_02();

        System.out.println("Hello, lets do some encryption.");

        if (exercise_02.getUserChoice().equals("encrypt")) {
            exercise_02.encryptFile();
        } else {
            exercise_02.decryptFile();
        }
    }

    public String getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"encrypt", "decrypt"};
        String answer;
        do {
            System.out.println("Do you want to encrypt or decrypt a file?");
            answer = scanner.next();
        }
        while (checkInput(answer, choices));
        return answer;
    }

    public void encryptFile() {
        String fileIn = getFileName("source");
        String fileOut = getFileName("new");
        int c;

        try (BufferedReader bufferIn = new BufferedReader(new FileReader(fileIn));
             BufferedWriter bufferOut = new BufferedWriter(new FileWriter(fileOut))) {
                while ((c = bufferIn.read()) != -1) {
                    bufferOut.write(c + 5);
                }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decryptFile() {
        String fileIn = getFileName("source");
        String fileOut = getFileName("new");
        int c;

        try (BufferedReader bufferIn = new BufferedReader(new FileReader(fileIn))) {
            try(BufferedWriter bufferOut = new BufferedWriter(new FileWriter(fileOut))){
                while ((c = bufferIn.read()) != -1) {
                    bufferOut.write(c - 5);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName(String type) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter " + type + " filename: ");
        return "src/labs_examples/input_output/files/" + scanner.next();
    }

    public boolean checkInput(String userInput, String... expected){
        for(String s : expected){
            if(userInput.equalsIgnoreCase(s)){
                return false;
            }
        }
        System.out.println(userInput + " is not a valid selection, please try again!");
        return true;
    }
}