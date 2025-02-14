package models;

// stores retrieved data from the storage system
public class DataReadResponse {
    
    private String data;

    public DataReadResponse(String data) {
        this.data = data;
    }

    public String getData() { 
        return data; 
    }

}
