package smoke;

import apis.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class TestDataStoreAPI {

    @Test
    public void testDataStoreAPI() {

        DataStoreAPI dataStore = new DataStoreImpl();

        InputConfig inputConfig = mock(InputConfig.class);
        OutputConfig outputConfig = mock(OutputConfig.class);

        //act
        DataStoreReadResult dataStoreReadResult = dataStore.read(inputConfig);
        WriteResult writeResult = dataStore.appendSingleResult(outputConfig, "9", ',');

        //assert
        assertTrue(dataStoreReadResult.getStatus() == DataStoreReadResult.Status.SUCCESS);
        assertTrue(writeResult.getStatus() == WriteResult.WriteResultStatus.SUCCESS);

        //TODO: add assertEquals for further verification

        //verify
        //TODO: verify methods were called

    }
}
