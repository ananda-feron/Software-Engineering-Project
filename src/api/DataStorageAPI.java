package api;

import models.DataReadRequest;
import models.DataReadResponse;
import models.DataWriteRequest;
import models.DataWriteResponse;

// the API between the compute engine and data storage
@ProcessAPI
public interface DataStorageAPI {

    DataReadResponse readData(DataReadRequest request);
    DataWriteResponse writeData(DataWriteRequest request);
    
}
