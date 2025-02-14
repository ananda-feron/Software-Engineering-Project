package project.annotations;

public class ComputerEngineAPIPrototype implements ComputerEngineAPI {
	
    @NetworkAPIPrototype
    public void prototypeMethod(ComputerEngineAPI api) {
        api.setSource("example_source.txt");
        api.setDelimiter(",");
        api.setDestination("output_file.csv");

        System.out.println("Prototype Simulation:");
        System.out.println("Source: " + api.getSource());
        System.out.println("Delimiter: " + api.getDelimiter());
        System.out.println("Destination: " + api.getDestination());
    }
    
}
