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

        List<Integer> integerList = new ArrayList<>();

        try {
            File inputFile = (File) input.getInput(); //is this cast fine?
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
            System.err.println("Error reading file. Error: " + ioException.getMessage());
            System.exit(1);
        }

        return new DataStoreReadResultImpl(DataStoreReadResult.Status.SUCCESS, integerList);
    }

    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result, char delimiter) {
        try {
            File outputFile = (File) output.getOutput();
            //validation
            if (!outputFile.exists()) {
                System.out.println("Output file " + outputFile + " does not exist. creating it...");
            }
            FileWriter writer = new FileWriter(outputFile);
            writer.write(result + delimiter + "\n");
            writer.close();

        } catch (IOException ioException) {
            System.err.println("Error writing to file. Error: " + result);
            System.exit(1);
        }
        return new WriteResultImpl(WriteResult.WriteResultStatus.SUCCESS);
    }
}
