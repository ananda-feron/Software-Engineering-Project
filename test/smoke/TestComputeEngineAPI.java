package smoke;

import apis.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TestComputeEngineAPI {

    @Test
    public void testComputeEngineAPI() {

        DataStoreAPI mockDataStore = mock(DataStoreAPI.class);
        ComputeEngineAPI computeEngineAPI = new ComputeEngineImpl(mockDataStore);

        //arrange

        //act
        String result = computeEngineAPI.compute(12);

        //assert
        assertEquals("9", result);
        //fails because ComputeEngine.compute returns null.

        //verify
        //TODO: verify methods were called


    }
}
