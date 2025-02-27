package integration;

import apis.*;
import implementations.ComputationCoordinator;
import implementations.ComputeEngine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComputeEngineIntegrationTest {

    @Test
    public void computeEngineIntegrationTest() {

        ComputeEngineAPI computeEngineAPI = new ComputeEngine();
        DataStoreAPI dataStoreAPI = new ListDataStore();
        ComputationCoordinatorAPI computationCoordinator = new ComputationCoordinator(computeEngineAPI, dataStoreAPI);

        InputConfig input = new ListInput(new ArrayList<Integer>(List.of(1,10,25)));
        OutputConfig output = new ListOutput(new ArrayList<String>());

        ComputeRequest computeRequest = new ComputeRequest(input, output);

        computationCoordinator.compute(computeRequest);

        assertEquals(output.getOutput(), new ArrayList<String>(List.of("1", "10,5,16,8,4,2,1", "25,76,38,19,58,29,88,44,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1")));

    }
}
