package smoke.testconceptualapi;

import org.junit.jupiter.api.Test;
import conceptualapi.InputStream;
import conceptualapi.ReceiveTaskRequest;
import conceptualapi.ReceiveTaskResponse;
import conceptualapi.SendTaskRequest;
import conceptualapi.SendTaskResponse;
import conceptualapi.PrototypeTaskHandler;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

public class TestConceptualAPI {

    InputStream mockInputStream = mock(InputStream.class);

    @Test
    public void testPrototypeReceiveTask() {

        ReceiveTaskResponse mockReceiveTaskResponse = mock(ReceiveTaskResponse.class);

        when(mockInputStream.receiveTask(any(ReceiveTaskRequest.class))).thenReturn(mockReceiveTaskResponse);

        PrototypeTaskHandler testComponent = new PrototypeTaskHandler();

        testComponent.prototype(mockInputStream);

        verify(mockInputStream).receiveTask(any(ReceiveTaskRequest.class));
    }

    @Test
    public void testPrototypeSendTask() {

        SendTaskResponse mockSendTaskResponse = mock(SendTaskResponse.class);

        when(mockInputStream.sendTask(any(SendTaskRequest.class))).thenReturn(mockSendTaskResponse);

        PrototypeTaskHandler testComponent = new PrototypeTaskHandler();

        testComponent.prototype(mockInputStream);

        verify(mockInputStream).sendTask(any(SendTaskRequest.class));
    }
}
