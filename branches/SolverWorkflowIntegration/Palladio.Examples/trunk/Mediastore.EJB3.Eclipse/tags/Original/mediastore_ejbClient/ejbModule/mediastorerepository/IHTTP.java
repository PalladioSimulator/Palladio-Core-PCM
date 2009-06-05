package mediastorerepository;

public interface IHTTP {
    byte[][] downloadHTTP(int[] desiredFiles);

    byte[][] queryFileByField(String queryString, int fieldID);
}
