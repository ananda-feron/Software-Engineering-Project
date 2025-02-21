package conceptualapi;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface InputStream {

    ReceiveTaskResponse receiveTask(ReceiveTaskRequest receiveTaskRequest);

    SendTaskResponse sendTask(SendTaskRequest sendTaskRequest);
}
