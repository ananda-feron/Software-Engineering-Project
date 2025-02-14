package models;

// requests to write data to a storage location
public class DataWriteRequest {
    
    private String destinationPath;
    private String data;

    public DataWriteRequest(String destinationPath, String data) {
        this.destinationPath = destinationPath;
        this.data = data;
    }

    public String getDestinationPath() { 
        return destinationPath; 
    }

    public String getData() { 
        return data; 
    }

}
