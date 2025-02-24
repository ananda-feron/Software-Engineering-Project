package apis;

import project.annotations.ConceptualAPIPrototype;

public class ComputeEnginePrototype {

    @ConceptualAPIPrototype
    public void prototype(ComputeEngineAPI computeEngine) {
        String result = computeEngine.compute(1);
    }

}
