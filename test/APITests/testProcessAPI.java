package APITests;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;

public class testProcessAPI {

    @Test
    public void testReadResponse(){
        Datastore mockDatastore = mockito.mock(Datastore.class);

        when(Datastore.readfromInput(any(ReadInputRequest.class))).thenReturn(new readResponse());

        PrototypeTaskHandler testComponent = newPrototypeTaskHandler(mockDataStore);

        verify(mockDataStore).readFromInput(any(ReadInputRequest.class));
    }

    @Test
    public void testWriteResponse(){
        Datastore mockDatastore = mockito.mock(Datastore.class);

        when(Datastore.writeToOutput(any(OutputDestinationRequest.class))).thenReturn(new WriteResponse());

        PrototypeTaskHandler testComponent = newPrototypeTaskHandler(mockDataStore);

        verify(mockDataStore).readFromInput(any(OutputDestinationRequest.class));
    }

}