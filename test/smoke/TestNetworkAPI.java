package smoke;

import computetaskhandlerapi.InputStream;
import org.junit.jupiter.api.Test;
import usercomputeapi.*;

import static org.mockito.Mockito.*;

public class TestNetworkAPI {

    ComputeEngine mockComputeEngine = mock(ComputeEngine.class);
    InputStream mockInputStream = mock(InputStream.class);

    EmptyImplementationNetworkAPI testUser = new EmptyImplementationNetworkAPI(mockInputStream);

    @Test
    public void testRequestInput() {
        InputSourceResponse mockInputSourceResponse = mock(InputSourceResponse.class);
        InputSourceRequest mockInputSourceRequest = mock(InputSourceRequest.class);

        when(mockComputeEngine.requestInput(any(InputSourceRequest.class))).thenReturn(mockInputSourceResponse);

        testUser.requestInput(mockInputSourceRequest);
        verify(mockComputeEngine).requestInput(any(InputSourceRequest.class));
    }

    @Test
    public void testRequestOutputDestination() {
        OutputDestinationResponse mockOutputDestinationResponse = mock(OutputDestinationResponse.class);
        OutputDestinationRequest mockOutputDestinationRequest = mock(OutputDestinationRequest.class);

        when(mockComputeEngine.requestOutputDestination(any(OutputDestinationRequest.class))).thenReturn(mockOutputDestinationResponse);

        testUser.requestOutputDestination(mockOutputDestinationRequest);
        verify(mockComputeEngine).requestOutputDestination(any(OutputDestinationRequest.class));
    }

    @Test
    public void testRequestDelimiter() {
        DelimiterResponse mockDelimiterResponse = mock(DelimiterResponse.class);
        DelimiterRequest mockDelimiterRequest = mock(DelimiterRequest.class);

        when(mockComputeEngine.requestDelimiter(any(DelimiterRequest.class))).thenReturn(mockDelimiterResponse);

        testUser.requestDelimiter(mockDelimiterRequest);
        verify(mockComputeEngine).requestDelimiter(any(DelimiterRequest.class));
    }

    @Test
    public void testSendData() {
        SendDataResponse mockSendDataResponse = mock(SendDataResponse.class);


        when(mockComputeEngine.sendData(any(InputSource.class), any(String.class), any(OutputDestination.class))).thenReturn(mockSendDataResponse);

        testUser.sendData(any(InputSource.class), any(String.class), any(OutputDestination.class));
        verify(mockComputeEngine).sendData(any(InputSource.class), any(String.class), any(OutputDestination.class));
    }

}
