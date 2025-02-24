package apis;

public class DataStorePrototype {

    public void prototype(DataStoreAPI dataStore) {

        InputConfig inputConfig = null;
        OutputConfig outputConfig = null;

        //read data
        DataStoreReadResult dataStoreReadResult = dataStore.read(inputConfig);

        //output data
        if (dataStoreReadResult.getStatus() == DataStoreReadResult.Status.SUCCESS) {
            Iterable<Integer> loadedData = dataStoreReadResult.getResults();

            for (int i : loadedData) {
                String result = "" + i;

                WriteResult writeResult = dataStore.appendSingleResult(outputConfig, result, ',');

                if (writeResult.getStatus() != WriteResult.WriteResultStatus.SUCCESS) {
                    System.out.println("error writing to output");
                }
            }
        }

    }
}
