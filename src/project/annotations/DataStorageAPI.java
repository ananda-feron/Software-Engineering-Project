package api;

import model.DataReadRequest;
import model.DataReadResponse;
import model.DataWriteRequest;
import model.DataWriteResponse;
import annotations.ProcessAPI;

@ProcessAPI
public interface DataStorageAPI {
    // reads in data requests (from: ...)
    DataReadResponse readData(DataReadRequest request);
    // writes out data requests (to: ...)
    DataWriteResponse writeData(DataWriteRequest request);
}
