package apis;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface ComputationCoordinatorAPI {
	ComputeResult compute(ComputeRequest request);
}
