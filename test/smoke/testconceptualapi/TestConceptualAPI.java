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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConceptualAPI {

    InputStream mockInputStream = mock(InputStream.class);
    PrototypeTaskHandler testComponent = new PrototypeTaskHandler();

    @Test
    public void testPrototypeReceiveTask() {

        ReceiveTaskResponse mockReceiveTaskResponse = mock(ReceiveTaskResponse.class);

        when(mockInputStream.receiveTask(any(ReceiveTaskRequest.class))).thenReturn(mockReceiveTaskResponse);

        testComponent.prototype(mockInputStream);

        assertEquals(mockReceiveTaskResponse, mockInputStream.receiveTask(any(ReceiveTaskRequest.class)));
    }

    @Test
    public void testPrototypeSendTask() {

        SendTaskResponse mockSendTaskResponse = mock(SendTaskResponse.class);

        when(mockInputStream.sendTask(any(SendTaskRequest.class))).thenReturn(mockSendTaskResponse);

        testComponent.prototype(mockInputStream);

        assertEquals(mockSendTaskResponse, mockInputStream.sendTask(any(SendTaskRequest.class)));
    }
}
