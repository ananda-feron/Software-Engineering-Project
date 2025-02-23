package apis;

public class ComputeEngineImpl implements ComputeEngineAPI {

    private final DataStoreAPI dataStore;

    public ComputeEngineImpl(DataStoreAPI dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public String compute(int value) {

        return null;

    }
}
