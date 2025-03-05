package smoke;

import implementations.ComputationCoordinator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import apis.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestComputationCoordinatorAPI {

    @Test
    public void testComputationCoordinatorAPI() {

        //mock api dependencies
        ComputeEngineAPI mockComputeEngine = mock(ComputeEngineAPI.class);
        DataStoreAPI mockDataStore = mock(DataStoreAPI.class);

        //initialize computationCoordinator
        ComputationCoordinatorAPI computationCoordinator = new ComputationCoordinator(mockComputeEngine, mockDataStore);

        //extra mocks
        InputConfig mockInputConfig = mock(InputConfig.class);
        OutputConfig mockOutputConfig = mock(OutputConfig.class);
        DataStoreReadResult mockDataStoreReadResult = mock(DataStoreReadResult.class);
        WriteResult mockWriteResult = mock(WriteResult.class);

        //new computeRequest
        ComputeRequest computeRequest = new ComputeRequest(mockInputConfig, mockOutputConfig, ',');

        ArrayList<Integer> integers = new ArrayList<>(List.of(1,2,3));

        //arrange
        when(mockDataStore.read(mockInputConfig)).thenReturn(mockDataStoreReadResult);
        when(mockDataStoreReadResult.getStatus()).thenReturn(DataStoreReadResult.Status.SUCCESS);
        when(mockDataStoreReadResult.getResults()).thenReturn(integers);
        when(mockComputeEngine.compute(any(Integer.class))).thenReturn("test");
        when(mockDataStore.appendSingleResult(mockOutputConfig, "test", computeRequest.getDelimiter())).thenReturn(mockWriteResult);
        when(mockWriteResult.getStatus()).thenReturn(WriteResult.WriteResultStatus.SUCCESS);

        //act
        ComputeResult computeResult = computationCoordinator.compute(computeRequest);

        //assert
        Assertions.assertTrue(computeResult.getStatus().isSuccess());
    }

    @Test
    public void testComputationCoordinatorInvalidRequest() {

        ComputeEngineAPI mockComputeEngine = mock(ComputeEngineAPI.class);
        DataStoreAPI mockDataStore = mock(DataStoreAPI.class);
        ComputationCoordinatorAPI computationCoordinator = new ComputationCoordinator(mockComputeEngine, mockDataStore);

        ComputeRequest computeRequest = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {computationCoordinator.compute(computeRequest);});

    }
}
