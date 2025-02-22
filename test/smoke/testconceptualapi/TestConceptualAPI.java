package smoke.testconceptualapi;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import conceptualapi.InputStream;
import conceptualapi.ReceiveTaskRequest;
import conceptualapi.ReceiveTaskResponse;
import conceptualapi.SendTaskRequest;
import conceptualapi.SendTaskResponse;
import conceptualapi.PrototypeTaskHandler;

public class TestConceptualAPI {

    @Test
    public void testPrototypeReceiveTask() {
        InputStream mockInputStream = mock(InputStream.class);

        ReceiveTaskResponse mockReceiveTaskResponse = mock(ReceiveTaskResponse.class);

        when(mockInputStream.receiveTask(any(ReceiveTaskRequest.class))).thenReturn(mockReceiveTaskResponse);

        PrototypeTaskHandler testComponent = new PrototypeTaskHandler();

        testComponent.prototype(mockInputStream);

        verify(mockInputStream).receiveTask(any(ReceiveTaskRequest.class));
    }

    @Test
    public void testPrototypeSendTask() {
        InputStream mockInputStream = mock(InputStream.class);

        SendTaskResponse mockSendTaskResponse = mock(SendTaskResponse.class);

        when(mockInputStream.sendTask(any(SendTaskRequest.class))).thenReturn(mockSendTaskResponse);

        PrototypeTaskHandler testComponent = new PrototypeTaskHandler();

        testComponent.prototype(mockInputStream);

        verify(mockInputStream).sendTask(any(SendTaskRequest.class));
    }
}