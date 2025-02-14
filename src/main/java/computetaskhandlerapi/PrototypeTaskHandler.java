package computetaskhandlerapi;

import project.annotations.ConceptualAPIPrototype;

public class PrototypeTaskHandler {

	@ConceptualAPIPrototype
    public void prototype(InputStream inputStream) {

        //receive task from compiler
        ReceiveTaskResponse receiveTaskResponse = inputStream.receiveTask(new ReceiveTaskRequest());

        //send to compute engine
        SendTaskResponse sendTaskResponse = inputStream.sendTask(new SendTaskRequest());

    }
}
