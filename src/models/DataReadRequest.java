package models;

// requests data to read from storage
public class DataReadRequest {
    
    private String sourcePath;

    public DataReadRequest(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getSourcePath() { 
        return sourcePath; 
    }

}
