package computetaskhandlerapi;

public class EmptyImplementationConceptualAPI implements InputStream {

    @Override
     public ReceiveTaskResponse receiveTask(ReceiveTaskRequest receiveTaskRequest){
        return null;
    }

    @Override
    public SendTaskResponse sendTask(SendTaskRequest sendTaskRequest){
        return null;
    }

}
