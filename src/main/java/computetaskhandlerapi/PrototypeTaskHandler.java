package computetaskhandlerapi;

public class PrototypeTaskHandler {

    public void prototype(InputStream inputStream) {

        //receive task from compiler
        ReceiveTaskResponse receiveTaskResponse = inputStream.receiveTask(new receiveTaskRequest());

        //send to compute engine
        SendTaskResponse sendTaskResponse = inputStream.sendTask(new SendTaskRequest());

    }
}
