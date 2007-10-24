package mediastorerepository;

public interface IMySQL {
    byte[][] getFiles(int[] FilesIDs);

    int[] getIDsOfMatchingFiles(String queryString, int fieldID);
}
