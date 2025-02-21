package conceptualapi;

import networkapi.ComputeEngine;

public class EmptyImplementationConceptualAPI implements InputStream {

    private ComputeEngine computeEngine;

    @Override
     public ReceiveTaskResponse receiveTask(ReceiveTaskRequest receiveTaskRequest){
        return null;
    }

    @Override
    public SendTaskResponse sendTask(SendTaskRequest sendTaskRequest){
        return null;
    }

}
