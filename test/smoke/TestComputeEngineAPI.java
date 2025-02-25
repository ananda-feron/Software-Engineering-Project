package smoke;

import apis.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestComputeEngineAPI {



    @Test
    public void testComputeEngineAPI() {

        //initialize ComputeEngine;
        ComputeEngineAPI computeEngineAPI = new ComputeEngineImpl();

        //act
        String result = computeEngineAPI.compute(12);

        //assert
        Assertions.assertEquals("12, 6, 3, 10, 5, 16, 8, 4, 2, 1", result);
    }
}
