package mediastorerepository;

public interface IAudioDB {
    byte[][] queryDB(int[] desiredFiles);

    byte[][] queryAndGetFromDB(String queryString, int fieldID);
}
