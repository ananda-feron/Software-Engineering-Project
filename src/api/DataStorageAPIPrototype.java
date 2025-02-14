package api;

import models.DataReadRequest;
import models.DataReadResponse;
import models.DataWriteRequest;
import models.DataWriteResponse;

// Reads and writes data from and to data storage (for ex. network)
@ProcessAPIPrototype
public class DataStorageAPIPrototype implements DataStorageAPI {

    @Override
    public DataReadResponse readData(DataReadRequest request) {
        System.out.println("Reading data from: " + request.getSourcePath());
        return new DataReadResponse("Sample data content");
    }

    @Override
    public DataWriteResponse writeData(DataWriteRequest request) {
        System.out.println("Writing data to: " + request.getDestinationPath());
        return new DataWriteResponse(true);
    }
  
}
