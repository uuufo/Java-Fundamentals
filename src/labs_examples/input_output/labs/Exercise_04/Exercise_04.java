package labs_examples.input_output.labs.Exercise_04;

import labs_examples.input_output.examples.csv_parser.Student;

import java.io.*;
import java.util.ArrayList;

/**
 *
 *      Following the video examples and source code found in the src/labs_examples/input_output/examples/csv_parser
 *      package, create a new application that will parse a custom CSV file that you created and map each line of the
 *      csv to a custom POJO that you create.
 *
 *      Then add that object to an arraylist. After you have mapped each row of the csv to objects
 *      and added each object to an arraylist, print out each object using the objects custom toString() method.
 *
 *      Then, write the arraylist of objects back out to a new .csv file. Ensure that the resulting csv file is valid.
 *
 */

public class Exercise_04 {

    public static void main(String[] args) {

        ArrayList<Electronic> electronics = new ArrayList<>();

        String fileIn = "src/labs_examples/input_output/files/electronics.csv";
        String fileOut = "src/labs_examples/input_output/files/electronics_2.csv";

        try (BufferedReader bufferIn = new BufferedReader(new FileReader(fileIn))) {
            String row;
            while ((row = bufferIn.readLine()) != null) {
                String[] values = row.split(",");
                electronics.add(createElectronic(values));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Electronic e : electronics) {
            System.out.println(e.toString());
        }

        try (BufferedWriter bufferOut = new BufferedWriter(new FileWriter(fileOut))) {
            for (Electronic e : electronics) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.getName()).append(",")
                    .append(e.getMake()).append(",")
                    .append(e.getModel()).append(",")
                    .append(e.getSerial()).append(",")
                    .append(e.getDesc())
                    .append("\n");
                bufferOut.write(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Electronic createElectronic(String[] values) {

        Electronic electronic = new Electronic();
        electronic.setName(values[0]);
        electronic.setMake(values[1]);
        electronic.setModel(values[2]);
        electronic.setSerial(values[3]);
        electronic.setDesc(values[4]);
        return electronic;

    }
}