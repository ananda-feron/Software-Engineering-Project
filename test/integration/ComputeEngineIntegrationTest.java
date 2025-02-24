package integration;

import apis.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComputeEngineIntegrationTest {

    @Test
    public void computeEngineIntegrationTest() {

        ComputeEngineAPI computeEngineAPI = new ComputeEngineImpl();
        DataStoreAPI dataStoreAPI = new InMemoryDataStoreImpl();
        ComputationCoordinatorAPI computationCoordinator = new ComputationCoordinatorImpl(computeEngineAPI, dataStoreAPI);

        InputConfig input = new ListInputImpl(new ArrayList<Integer>(List.of(1,10,25)));
        OutputConfig output = new ListOutputImpl(new ArrayList<String>());

        ComputeRequest computeRequest = new ComputeRequest(input, output);

        computationCoordinator.compute(computeRequest);

        assertEquals(output.getOutput(), "1,6,23");





    }
}
