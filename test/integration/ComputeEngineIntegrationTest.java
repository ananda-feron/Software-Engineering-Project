package integration;

import apis.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputeEngineIntegrationTest {

    @Test
    public void computeEngineIntegrationTest() {

        DataStoreAPI dataStore = new DataStoreImpl();
        ComputeEngineAPI computeEngine = new ComputeEngineImpl(dataStore);
        InputConfig inputConfig = new ListInputImpl(List.of(1,10,25));
        OutputConfig outputConfig = new ListOutputImpl(List.of(""));

        ComputeRequest request = new ComputeRequest(inputConfig, outputConfig);

        //some part of the computeEngineAPI will take a ComputeRequest as a parameter, and
        // will send to the datastore.

        // why am i being asked to write an integration test for two compute engine components,
        // when one hasnt even been implemented yet?????





    }
}
