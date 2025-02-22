package smoke.testprocessapi;

import org.junit.jupiter.api.Test;
import processapi.DataStore;
import processapi.ReadInputRequest;
import processapi.ReadInputResponse;
import processapi.WriteOutputRequest;
import processapi.WriteOutputResponse;
import processapi.PrototypeComputeStorage;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

public class TestProcessAPI {

    DataStore mockDatastore = mock(DataStore.class);
    PrototypeComputeStorage testComponent = new PrototypeComputeStorage();

    @Test
    public void testReadResponse() {

        ReadInputResponse mockReadInputResponse = mock(ReadInputResponse.class);

        when(mockDatastore.readFromInput(any(ReadInputRequest.class)))
                .thenReturn(mockReadInputResponse);

        testComponent.prototype(mockDatastore);

        verify(mockDatastore).readFromInput(any(ReadInputRequest.class));
    }

    @Test
    public void testWriteResponse() {
        WriteOutputResponse mockWriteOutputResponse = mock(WriteOutputResponse.class);

        when(mockDatastore.writeToOutput(any(WriteOutputRequest.class)))
                .thenReturn(mockWriteOutputResponse);

        testComponent.prototype(mockDatastore);

        verify(mockDatastore).writeToOutput(any(WriteOutputRequest.class));
    }
}

