package smoke;

import computetaskhandlerapi.InputStream;
import org.junit.jupiter.api.Test;
import usercomputeapi.*;

import static org.mockito.Mockito.*;

public class TestNetworkAPI {

    @Test
    public void testInputSourceResponse() {
        ComputeEngine mockComputeEngine = mock(ComputeEngine.class);
        InputSourceResponse mockInputSourceResponse = mock(InputSourceResponse.class);
        InputSourceRequest mockInputSourceRequest = mock(InputSourceRequest.class);
        InputStream mockInputStream = mock(InputStream.class);

        when(mockComputeEngine.requestInput(any(InputSourceRequest.class))).thenReturn(mockInputSourceResponse);

        EmptyImplementationNetworkAPI testUser = new EmptyImplementationNetworkAPI(mockInputStream);
        testUser.requestInput(mockInputSourceRequest);
        verify(mockComputeEngine).requestInput(any(InputSourceRequest.class));
    }

}
