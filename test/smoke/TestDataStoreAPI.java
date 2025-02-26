package smoke;

import apis.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


public class TestDataStoreAPI {

    @Test
    public void testDataStoreAPI() {

        DataStoreAPI dataStore = new DataStoreImpl();

        InputConfig inputConfig = mock(InputConfig.class);
        OutputConfig outputConfig = mock(OutputConfig.class);

        //act
        DataStoreReadResult dataStoreReadResult = dataStore.read(inputConfig);
        WriteResult writeResult = dataStore.appendSingleResult(outputConfig, "9", ','); //fix

        //assert
        Assertions.assertSame(DataStoreReadResult.Status.SUCCESS, dataStoreReadResult.getStatus());
        Assertions.assertSame(WriteResult.WriteResultStatus.SUCCESS, writeResult.getStatus());

        //TODO: this is still failing because DataStoreImpl is unimplemented!
        //TODO: add assertEquals for further verification?


    }
}
