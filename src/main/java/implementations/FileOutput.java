package implementations;

import apis.OutputConfig;

import java.io.File;

public class FileOutput implements OutputConfig<File> {

    private final File outputFile;

    public FileOutput(String filePath) {
        this.outputFile = new File(filePath);
    }

    @Override
    public File getOutput() {
        return outputFile;
    }
}
