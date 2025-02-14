package project.annotations;

public class ComputerEnginePrototype implements ComputerEngine {
	
	private String source;
    private String delimiter = ","; // Default delimiter
    private String destination;
	
    @NetworkAPIPrototype
    public void setSource(String source) {
        // Logic to set source (file, networked drive, etc.)
    	this.source = source;
    }
    
    @NetworkAPIPrototype
    public void setDelimiter(String delimiter) {
        // Logic to set delimiter (default or custom)
    	if (delimiter == null || delimiter.isEmpty()) {
            this.delimiter = ",";  // Use default if no delimiter is provided
        } else {
            this.delimiter = delimiter;
        }
    	
    }

    @NetworkAPIPrototype
    public void setDestination(String destination) {
        // Logic to set destination (file, networked drive, etc.)
    	this.destnation = destination;
    }
    
    @NetworkAPIPrototype
    public String getSource() {
        return source;
    }

    @NetworkAPIPrototype
    public String getDelimiter() {
        return delimiter;
    }

    @NetworkAPIPrototype
    public String getDestination() {
        return destination;
    }
    
}
