package project.annotations;

@NetworkAPI
public interface ComputerEngineAPI {
    void setSource(String source);  // Set the source (file, networked drive, etc.)
    void setDelimiter(String delimiter);  // Set the delimiter (can be default or custom)
    void setDestination(String destination);  // Set the destination (file, networked drive, etc.)

    String getSource();
    String getDelimiter();
    String getDestination();
}
