package mediastorerepository.impl;

public interface IWebGUI {
    byte[][] iHTTP_downloadHTTP(int[] desiredFiles);

    byte[][] iHTTP_queryFileByField(String queryString, int fieldID);
}
