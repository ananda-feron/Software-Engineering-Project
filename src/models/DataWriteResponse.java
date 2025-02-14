package models;

// response after an attempt to write data
public class DataWriteResponse {

    private boolean success;

    public DataWriteResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccessful() { 
        return success; 
    }

}
