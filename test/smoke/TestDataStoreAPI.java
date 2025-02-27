package smoke;

import apis.*;
import implementations.FileDataStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestDataStoreAPI {

    @Test
    public void testDataStoreAPI() {

        DataStoreAPI dataStore = new FileDataStore();

        InputConfig mockInputConfig = mock(InputConfig.class);
        OutputConfig mockOutputConfig = mock(OutputConfig.class);

        //arrange
        when(mockInputConfig.getInput()).thenReturn(new File("test/smoke/test-input.txt"));
        when(mockOutputConfig.getOutput()).thenReturn(new File("test/smoke/test-output.txt"));

        //act
        //read from test-input.txt
        DataStoreReadResult dataStoreReadResult = dataStore.read(mockInputConfig);
        //write to test-output.txt
        WriteResult writeResult = dataStore.appendSingleResult(mockOutputConfig, "example", ',');

        //assert
        Assertions.assertSame(DataStoreReadResult.Status.SUCCESS, dataStoreReadResult.getStatus());
        Assertions.assertEquals(dataStoreReadResult.getResults(), new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5)));

        Assertions.assertSame(WriteResult.WriteResultStatus.SUCCESS, writeResult.getStatus());

    }
}
