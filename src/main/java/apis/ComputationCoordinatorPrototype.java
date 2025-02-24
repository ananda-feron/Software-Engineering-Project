package apis;

import project.annotations.NetworkAPIPrototype;

public class ComputationCoordinatorPrototype {

    @NetworkAPIPrototype
    public void prototype(ComputationCoordinatorAPI computationCoordinator) {

        InputConfig inputConfig = null;
        OutputConfig outputConfig = null;

        //create a new compute request
        ComputeRequest computeRequest = new ComputeRequest(inputConfig, outputConfig, ',');

        //compute the result
        ComputeResult computeResult = computationCoordinator.compute(computeRequest);

    }

}
