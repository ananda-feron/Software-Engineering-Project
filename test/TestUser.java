import apis.ComputationCoordinatorAPI;
import apis.ComputeRequest;
import implementations.ComputationCoordinator;
import implementations.ComputeResult;
import implementations.FileInput;
import implementations.FileOutput;

import java.io.File;


public class TestUser {
	
	// TODO 3: change the type of this variable to the name you're using for your
	// @NetworkAPI interface; also update the parameter passed to the constructor
	private final ComputationCoordinator coordinator;

	public TestUser(ComputationCoordinator coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		
		// TODO 4: Call the appropriate method(s) on the coordinator to get it to 
		// run the compute job specified by inputPath, outputPath, and delimiter
		// Wrap paths in InputConfig and OutputConfig objects
		FileInput inputConfig = new FileInput(inputPath);
		FileOutput outputConfig = new FileOutput(outputPath);

		// Create ComputeRequest with proper input and output
		ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, delimiter);

		// Run computation
		ComputeResult result = coordinator.compute(request);

		// Print result
		System.out.println("Computation Result: " + result);
	}

}
