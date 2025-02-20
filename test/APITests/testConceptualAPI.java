package APITests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import computetaskhandlerapi.InputStream;
import computetaskhandlerapi.ReceiveTaskRequest;
import computetaskhandlerapi.ReceiveTaskResponse;
import computetaskhandlerapi.SendTaskRequest;
import computetaskhandlerapi.SendTaskResponse;
import computetaskhandlerapi.PrototypeTaskHandler;


public class testConceptualAPI {

    @Test
    public void testReceiveTaskResponse(){
        InputStream mockInputStream = Mockito.mock(InputStream.class);

        when(mockInputStream.receiveTask(any(ReceiveTaskRequest.class))).thenReturn(new ReceiveTaskResponse());

        PrototypeTaskHandler testComponent = new PrototypeTaskHandler(mockInputStream);

        verify(mockInputStream).receiveTask(any(ReceiveTaskRequest.class));
    }

    @Test
    public void testSendTaskResponse(){
        InputStream mockInputStream = mockito.mock(InputStream.class);

        when(mockInputStream.sendTask(any(SendTaskResponse.class))).thenReturn(new SendTaskResponse());

        PrototypeTaskHandler testComponent = newPrototypeTaskHandler(mockInputStream);

        verify(mockInputStream).sendTask(any(SendTaskRequest.class));
    }

}