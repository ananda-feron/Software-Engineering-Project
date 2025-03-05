package smoke;

import apis.*;
import implementations.ComputeEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestComputeEngineAPI {



    @Test
    public void testComputeEngineAPI() {

        //initialize ComputeEngine;
        ComputeEngineAPI computeEngineAPI = new ComputeEngine();

        //act
        String result = computeEngineAPI.compute(12);

        //assert
        Assertions.assertEquals("12,6,3,10,5,16,8,4,2,1", result);
    }

    @Test
    public void testNegativeNumberError() {
        ComputeEngineAPI computeEngineAPI = new ComputeEngine();

        // Assert that calling compute() with a negative number throws an exception
        Assertions.assertEquals("Invalid input: " + -10 + ". Please provide a positive number.",   computeEngineAPI.compute(-10));
    }

    @Test
    public void testOverflowError() {
        ComputeEngineAPI computeEngineAPI = new ComputeEngine();

        //I don't know if this is redundant since runtime errors exist
        //However we do need to return a value instead of throw an exception
        Assertions.assertEquals("Input value is too large and could cause overflow during computation.", computeEngineAPI.compute(715827883));
    }

}
