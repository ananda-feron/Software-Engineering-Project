package computetaskhandlerapi;

public interface InputStream {

    ReceiveTaskResponse receiveTask(ReceiveTaskRequest receiveTaskRequest);

    SendTaskResponse sendTask(SendTaskRequest sendTaskRequest);
}
