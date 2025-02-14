package models;

// reads in data requests
public class DataReadRequest {
    private String sourcePath;
    
    public DataReadRequest(String sourcePath) {
        this.sourcePath = sourcePath;
    }
  
    public String getSourcePath() { return sourcePath; }
}

