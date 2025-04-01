import apis.ComputeEngineAPI;
import apis.DataStoreAPI;
import implementations.ComputationCoordinator;
import implementations.ComputeEngine;
import implementations.FileDataStore;

import java.io.File;

public class TestUserProgram {
    public static void main(String[] args) {
        // Create the required components for ComputationCoordinator
        ComputeEngineAPI computeEngine = new ComputeEngine(); // Replace with actual implementation
        DataStoreAPI dataStore = new FileDataStore(); // Replace with actual implementation

        // Create the ComputationCoordinator instance
        ComputationCoordinator coordinator = new ComputationCoordinator(computeEngine, dataStore);

        // Create the TestUser instance
        TestUser testUser = new TestUser(coordinator);

        // Define an output path for the result file
        String outputPath = "test" + File.separator + "testOutputFile.test";

        // Run the computation
        testUser.run(outputPath);
    }
}
