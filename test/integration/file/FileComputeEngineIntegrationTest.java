package integration.file;

import apis.*;
import implementations.*;
import apis.ComputeResult;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FileComputeEngineIntegrationTest {

    ComputeEngineAPI computeEngineAPI = new ComputeEngine();
    DataStoreAPI dataStoreAPI = new FileDataStore();
    ComputationCoordinatorAPI computationCoordinator = new ComputationCoordinator(computeEngineAPI, dataStoreAPI);

    InputConfig input = new FileInput("test/integration/file/input.txt");
    OutputConfig output = new FileOutput("test/integration/file/output.txt");



    @Test
    public void testNullRequest() {
        ComputeRequest request = null;

        ComputeResult result = computationCoordinator.compute(request);

        assertEquals(ComputeResult.ComputeResultStatus.FAILURE, result.getStatus());
        assertEquals("Error: request is invalid", result.getFailureMessage());
    }

    @Test
    public void testNullInput() {
        ComputeRequest request = new ComputeRequest(null, output);

        ComputeResult result = computationCoordinator.compute(request);

        assertEquals(ComputeResult.ComputeResultStatus.FAILURE, result.getStatus());
        assertEquals("Input is invalid.", result.getFailureMessage());
    }

    @Test
    public void testMissingInputFile() {
        InputConfig input = new FileInput("non-existent-input.txt");

        ComputeRequest request = new ComputeRequest(input, output);

        ComputeResult result = computationCoordinator.compute(request);

        assertEquals(ComputeResult.ComputeResultStatus.FAILURE, result.getStatus());
        assertEquals("Error reading file: " + input.getInput() + " (No such file or directory)", result.getFailureMessage());
    }

//    @Test
//    public void testNegativeNumber() {
//        InputConfig input = new FileInput("test/integration/file/negative.txt");
//
//        ComputeRequest request = new ComputeRequest(input, output);
//
//        ComputeResult result = computationCoordinator.compute(request);
//
//        assertEquals(ComputeResult.ComputeResultStatus.COMPUTATION_FAILURE, result.getStatus());
//        assertEquals("Error computing value: Number cannot be negative", result.getFailureMessage());
//    }

}
