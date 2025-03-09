package implementations;

import apis.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;

public class FileDataStore implements DataStoreAPI {
    @Override
    public DataStoreReadResult read(InputConfig input) {

        try {
            if (input == null) {
                return new DataStoreReadResultImpl(DataStoreReadResult.Status.FAILURE, null, "Input is invalid.");
            }


            List<Integer> integerList = new ArrayList<>();

            try {
                File inputFile = (File) input.getInput();
                Scanner scanner = new Scanner(inputFile);
                while (scanner.hasNextLine()) {
                    String[] values = scanner.nextLine().split(",");
                    //assumed to be .csv file
                    for (String value : values) {
                        try { //(validation)
                            integerList.add(Integer.parseInt(value));
                        } catch (NumberFormatException numberFormatException) {
                            System.err.println("skipping invalid number: " + value);
                        }
                    }
                }
            } catch (IOException ioException) {
                return new DataStoreReadResultImpl(DataStoreReadResult.Status.FAILURE, null, "Error reading file: " + ioException.getMessage());
            }

            return new DataStoreReadResultImpl(DataStoreReadResult.Status.SUCCESS, integerList, "Successfully read file.");
        } catch (Exception e){
            return new DataStoreReadResultImpl(DataStoreReadResult.Status.FAILURE, null, "Unexpected runtime error: " + e.getMessage());
        }
    }

    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result, char delimiter) {
        try {
            if (output == null) {
                return new WriteResultImpl(WriteResult.WriteResultStatus.FAILURE, "Output is invalid.");
            }
            try {
                File outputFile = (File) output.getOutput();
                if (!outputFile.exists()) {
                    System.out.println("Output file " + outputFile + " does not exist. creating it...");
                }
                FileWriter writer = new FileWriter(outputFile);
                writer.write(result + delimiter + "\n");
                writer.close();

            } catch (IOException ioException) {
                return new WriteResultImpl(WriteResult.WriteResultStatus.FAILURE, "Error writing to file: " + ioException.getMessage());
            }
            return new WriteResultImpl(WriteResult.WriteResultStatus.SUCCESS, "Success writing to file.");

        } catch (Exception e){
            return new WriteResultImpl(WriteResult.WriteResultStatus.FAILURE, "Unexpected runtime error: " + e.getMessage());
        }

    }
}
