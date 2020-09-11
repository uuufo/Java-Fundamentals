package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 1: File input/output
 *
 *      Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 *      Make sure you close the connections to both files.
 *
 *
 */

class Example {
    public static void main(String[] args) {

        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] buffer = new byte[5];
        int bytes;

        String fileReadPath = "src/labs_examples/input_output/files/byte_data";
        String fileWritePath = "src/labs_examples/input_output/files/exercise_01_new.txt";

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileReadPath));
            fileOutputStream = new FileOutputStream(fileWritePath);
            while ((bytes = bufferedInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}