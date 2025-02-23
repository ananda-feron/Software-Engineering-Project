package smoke;

import org.junit.jupiter.api.Test;
import apis.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class TestComputationCoordinatorAPI {

    @Test
    public void testComputationCoordinatorAPI() {

        ComputeEngineAPI mockComputeEngine = mock(ComputeEngineAPI.class);
        ComputationCoordinatorAPI computationCoordinator = new ComputationCoordinatorImpl(mockComputeEngine);

        InputConfig inputConfig = mock(InputConfig.class);
        OutputConfig outputConfig = mock(OutputConfig.class);
        ComputeRequest computeRequest = new ComputeRequest(inputConfig, outputConfig, ',');

        //arrange
        //n.a.


        //act
        ComputeResult computeResult = computationCoordinator.compute(computeRequest);

        //assert
        assertTrue(computeResult.getStatus().isSuccess());
        //fails because ComputationCoordinator.compute() returns null right now. this is what we want.


    }
}
