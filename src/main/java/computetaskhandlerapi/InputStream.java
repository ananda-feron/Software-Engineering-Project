package computetaskhandlerapi;

public interface InputStream {

    ReceiveTaskResponse receiveTask(receiveTaskRequest receiveTaskRequest);

    SendTaskResponse sendTask(SendTaskRequest sendTaskRequest);
}
