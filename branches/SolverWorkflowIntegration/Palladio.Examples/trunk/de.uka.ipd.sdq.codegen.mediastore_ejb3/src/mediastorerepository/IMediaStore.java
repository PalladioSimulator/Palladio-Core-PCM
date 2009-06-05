package mediastorerepository;

public interface IMediaStore {
    byte[][] downloadFromDB(int[] desiredFiles);

    byte[][] queryAndGetFromDB(String queryString, int fieldID);
}
