package APITests;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;

public class testNetworkAPI {

    @Test
    public void testInputSourceResponse() {

        ComputeEngine mockComputeEngine = mock(ComputeEngine.class);
        InputSourceResponse mockInputSourceResponse = mock(InputSourceResponse.class);

        when(mockComputeEngine.requestInput(any(InputSourceRequest.class))).thenReturn(mockInputSourceResponse);

        PrototypeUserToCompute prototypeUser = new PrototypeUserToCompute();

        prototypeUser.prototype(mockComputeEngine);

        verify(mockComputeEngine).requestInput(any(InputSourceRequest.class));
    }

    @Test
    public void testDelimiterResponse() {

        ComputeEngine mockComputeEngine = mock(ComputeEngine.class);
        DelimiterResponse mockDelimiterResponse = mock(DelimiterResponse.class);

        when(mockComputeEngine.requestDelimiter(any(DelimiterRequest.class))).thenReturn(mockDelimiterResponse);
        when(mockDelimiterResponse.getDelimiter()).thenReturn(",");

        PrototypeUserToCompute prototypeUser = new PrototypeUserToCompute();

        prototypeUser.prototype(mockComputeEngine);

        verify(mockComputeEngine).requestDelimiter(any(DelimiterRequest.class));
        assertEquals(",", mockDelimiterResponse.getDelimiter());
    }

    @Test
    public void testOutputDestinationResponse() {

        ComputeEngine mockComputeEngine = mock(ComputeEngine.class);
        OutputDestinationResponse mockOutputDestinationResponse = mock(OutputDestinationResponse.class);

        when(mockComputeEngine.requestOutputDestination(any(OutputDestinationRequest.class))).thenReturn(mockOutputDestinationResponse);

        PrototypeUserToCompute prototypeUser = new PrototypeUserToCompute();

        prototypeUser.prototype(mockComputeEngine);

        verify(mockComputeEngine).requestOutputDestination(any(OutputDestinationRequest.class));
    }

    @Test
    public void testSendDataResponse() {

        ComputeEngine mockComputeEngine = mock(ComputeEngine.class);
        InputSourceResponse mockInputSourceResponse = mock(InputSourceResponse.class);
        DelimiterResponse mockDelimiterResponse = mock(DelimiterResponse.class);
        OutputDestinationResponse mockOutputDestinationResponse = mock(OutputDestinationResponse.class);
        SendDataResponse mockSendDataResponse = mock(SendDataResponse.class);


        when(mockComputeEngine.requestInput(any(InputSourceRequest.class))).thenReturn(mockInputSourceResponse);
        when(mockComputeEngine.requestDelimiter(any(DelimiterRequest.class))).thenReturn(mockDelimiterResponse);
        when(mockComputeEngine.requestOutputDestination(any(OutputDestinationRequest.class))).thenReturn(mockOutputDestinationResponse);
        when(mockComputeEngine.sendData(anyString(), anyString(), anyString())).thenReturn(mockSendDataResponse);


        PrototypeUserToCompute prototypeUser = new PrototypeUserToCompute();


        prototypeUser.prototype(mockComputeEngine);


        verify(mockComputeEngine).sendData(anyString(), anyString(), anyString());
        verify(mockComputeEngine).requestInput(any(InputSourceRequest.class));
        verify(mockComputeEngine).requestDelimiter(any(DelimiterRequest.class));
        verify(mockComputeEngine).requestOutputDestination(any(OutputDestinationRequest.class));
    }
}
