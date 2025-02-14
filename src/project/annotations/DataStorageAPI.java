package project.annotations;

@ProcessAPI
public interface DataStorageAPI {
    // reads in data requests ("from: ...")
    void readData();
    // writes out data requests ("to: ...")
    void writeData();
}
