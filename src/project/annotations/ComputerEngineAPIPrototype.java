package project.annotations;

public class ComputerEngineAPIPrototype implements ComputerEngineAPI {
	
    private String source;
    private String delimiter = ","; // Default delimiter
    private String destination;

    //set the source
    @NetworkAPIPrototype
    public void setSource(String source) {
        // Logic to set source (file, networked drive, etc.)
    	this.source = source;
    }

    //set the delimiters
    @NetworkAPIPrototype
    public void setDelimiter(String delimiter) {
        // Logic to set delimiter (default or custom)
    	if (delimiter == null || delimiter.isEmpty()) {
            this.delimiter = ",";  // Use default if no delimiter is provided
        } else {
            this.delimiter = delimiter;
        }
    	
    }

    //set the destination
    @NetworkAPIPrototype
    public void setDestination(String destination) {
        // Logic to set destination (file, networked drive, etc.)
    	this.destnation = destination;
    }

    //get the source from user
    @NetworkAPIPrototype
    public String getSource() {
        return source;
    }

    //get the delimiter from user input
    @NetworkAPIPrototype
    public String getDelimiter() {
        return delimiter;
    }

    //get the destination from user
    @NetworkAPIPrototype
    public String getDestination() {
        return destination;
    }
    
}
