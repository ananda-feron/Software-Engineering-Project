package project.annotations;

public class ComputerEnginePrototype implements ComputerEngine {
	
    @NetworkAPIPrototype
    public void setSource(String source) {
        // Logic to set source (file, networked drive, etc.)
    }
    
    @NetworkAPIPrototype
    public void setDelimiter(String delimiter) {
        // Logic to set delimiter (default or custom)
    }

    @NetworkAPIPrototype
    public void setDestination(String destination) {
        // Logic to set destination (file, networked drive, etc.)
    }
    
}
