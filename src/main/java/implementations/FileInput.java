package implementations;

import apis.InputConfig;

import java.io.File;

public class FileInput implements InputConfig {

    private final File inputFile;

    public FileInput(String filePath) {
        this.inputFile = new File(filePath);
    }

    @Override
    public File getInput() {
        return inputFile;
    }
}
