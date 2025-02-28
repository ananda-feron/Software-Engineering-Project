package integration;

import apis.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import implementations.*;
import integration.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeEngineIntegrationTest {

    @Test
    public void computeEngineIntegrationTest() {

        ComputeEngineAPI computeEngineAPI = new ComputeEngine();
        DataStoreAPI dataStoreAPI = new DataStore();
        ComputationCoordinatorAPI computationCoordinator = new ComputationCoordinator(computeEngineAPI, dataStoreAPI);

        InputConfig input = new ListInput(new ArrayList<>(List.of(1,10,25)));
        OutputConfig output = new ListOutput(new ArrayList<>());

        ComputeRequest computeRequest = new ComputeRequest(input, output);

        computationCoordinator.compute(computeRequest);

        assertEquals(new ArrayList<>(List.of("1", "10,5,16,8,4,2,1", "25,76,38,19,58,29,88,44,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1")), output.getOutput());

    }
}
