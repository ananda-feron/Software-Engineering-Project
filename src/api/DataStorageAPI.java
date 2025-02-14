package api;

import model.DataReadRequest;
import model.DataReadResponse;
import model.DataWriteRequest;
import model.DataWriteResponse;
import annotations.ProcessAPI;

@ProcessAPI
public interface DataStorageAPI {
    DataReadResponse readData(DataReadRequest request);
    DataWriteResponse writeData(DataWriteRequest request);
}
