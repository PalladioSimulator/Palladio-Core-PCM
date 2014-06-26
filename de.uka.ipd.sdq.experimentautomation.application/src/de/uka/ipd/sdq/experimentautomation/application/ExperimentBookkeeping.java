package de.uka.ipd.sdq.experimentautomation.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;

public class ExperimentBookkeeping {

    private static final Logger logger = Logger.getLogger(ExperimentApplication.class);
    private static final String METADATA_FILE = "metadata.txt";
    private static final String ERROR_LOG_FILE = "errorlog.txt";
    private static final String RESULTS_FILE = "results.csv";
    private static final String CSV_COLUMN_DELIMITER = ";";

    private File experimentFolder;
    private PrintWriter resultWriter;
    private int columnsCount;

    /**
     * Default constructor.
     * 
     * @param folder
     *            the folder in which experiment results and metadata will be stored
     */
    public ExperimentBookkeeping(File folder) {
        assert folder != null : "The folder may not be null";
        if (folder.exists()) {
            throw new RuntimeException("There is already a file or folder named " + folder);
        }
        this.experimentFolder = folder;

        // create folder
        logger.debug("Creating folder " + folder.getPath());
        boolean created = folder.mkdir();
        if (!created) {
            throw new RuntimeException("Could not create folder " + folder);
        }
    }
    
    public void prepareResultFile(String[] responseVariableNames, String[] columnNames) {
        String[] headerNames = new String[responseVariableNames.length + columnNames.length];
        for(int i = 0; i < responseVariableNames.length; i++) {
            headerNames[i] = responseVariableNames[i];
        }
        for(int i = 0; i< columnNames.length; i++) {
            headerNames[responseVariableNames.length+i] = columnNames[i];
        }
        
        this.columnsCount = headerNames.length;
        URI resultFileUri = createExperimentFolderUri(RESULTS_FILE);
        File resultFile = new File(resultFileUri.toFileString());
        resultWriter = createAndOpenFile(resultFile);
        for (int i = 0; i < headerNames.length; i++) {
            resultWriter.print(headerNames[i]);
            if (i + 1 < headerNames.length) {
                resultWriter.print(CSV_COLUMN_DELIMITER);
            }
        }
        resultWriter.println();
        resultWriter.flush();
    }

    public void addResult(String responses[], String[] factorLevels) {
        String[] cols = new String[responses.length + factorLevels.length];
        for(int i = 0; i < responses.length; i++) {
            cols[i] = responses[i];
        }
        for(int i = 0; i< factorLevels.length; i++) {
            cols[responses.length+i] = factorLevels[i];
        }
        
        
        if (resultWriter == null) {
            throw new IllegalStateException("The result file needs to be initialised first");
        }
//        assert (this.columnsCount == columns.length) : "The result file has been initialised with " + columnsCount
//                + " columns, but tried to write " + columns.length + " columns.";
        for (int i = 0; i < cols.length; i++) {
            resultWriter.print(cols[i]);
            if (i + 1 < cols.length) {
                resultWriter.print(CSV_COLUMN_DELIMITER);
            }
        }
        resultWriter.println();
        resultWriter.flush();
    }

    public void finishResultFile() {
        if (resultWriter != null) {
            resultWriter.close();
        }
    }

    /**
     * Copies the files referenced by the specified model to the experiment folder.
     * 
     * @param model
     *            the model whose files are to be copied
     */
    public void copyModelFilesToExperimentFolder(PCMModelFiles model) {

    }

    /**
     * Writes the metadata to a new file in the experiment folder.
     * 
     * @param metadata
     *            the metadata which is to be stored in a newly created file
     */
    public void writeMetadata(ExperimentMetadata metadata) {
        URI absoluteMetadataUri = createExperimentFolderUri(METADATA_FILE);
        File metadataFile = new File(absoluteMetadataUri.toFileString());
        PrintWriter writer = createAndOpenFile(metadataFile);
        writer.print(metadata);
        writer.close();
    }

    public void logException(Exception ex) {
    	ex.printStackTrace();
    	
        URI absoluteErrorLogUri = createExperimentFolderUri("errorlog_" + System.currentTimeMillis() + ".txt");
        File logFile = new File(absoluteErrorLogUri.toFileString());
        PrintWriter writer = createAndOpenFile(logFile);
        ex.printStackTrace(writer);
        writer.close();
    }

    private URI createExperimentFolderUri(String fileName) {
        URI experimentFolderUri = URI.createFileURI(experimentFolder.getPath() + File.separator);
        URI relativeMetadataUri = URI.createURI(fileName);
        URI absoluteMetadataUri = relativeMetadataUri.resolve(experimentFolderUri);
        return absoluteMetadataUri;
    }

    private PrintWriter createAndOpenFile(File file) {
        try {
            if (file.exists()) {
                throw new RuntimeException("The file " + file + " does already exists.");
            } else {
                boolean created = file.createNewFile();
                if (!created) {
                    throw new RuntimeException("Could not create file " + file);
                }
            }
            return new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getExperimentFolder() {
        return experimentFolder;
    }

}
