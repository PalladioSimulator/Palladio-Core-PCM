package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.reliability.core.helper.EMFHelper;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovTransformationResult;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;

/**
 * Base class for (rudimentary) sensitivity analysis.
 * 
 * Further refactorings required.
 * 
 * @author brosch
 * 
 */
public abstract class MarkovSensitivity {

    /**
     * Character used to separate entries in the sensitivity log file.
     */
    private static final String LOG_ENTRY_SEPARATOR = "\\";

    /**
     * A logger to give detailed information about the PCM instance transformation.
     */
    protected static final Logger LOGGER = Logger.getLogger(MarkovSensitivity.class);

    /**
     * A calculator for variations and steps during the sensitivity analysis.
     */
    protected SensitivityCalculator calculator = new SensitivityCalculator();

    /**
     * The current sensitivity analysis step.
     */
    private int currentStepNumber = 0;

    /**
     * Provides EMF utility functions.
     */
    protected EMFHelper helper = new EMFHelper();

    /**
     * Stores the contents of the log file.
     */
    private List<List<String>> logContents = null;

    /**
     * Provides a writer to the log file.
     */
    protected BufferedWriter logWriter = null;

    /**
     * The model on which sensitivity analysis is based.
     */
    protected PCMInstance model;

    /**
     * The name of this sensitivity (for logging).
     */
    protected String name = null;

    /**
     * The number of steps to take during sensitivity analysis.
     */
    protected int numberOfSteps;

    /**
     * The log file for sensitivity results.
     */
    private String resultLogfile = null;

    /**
     * The list of relevant Markov analysis results.
     */
    private EList<SensitivityResultSpecification> resultSpecifications = null;

    /**
     * The variation of this sensitivity analysis.
     */
    private SensitivityParameterVariation variation = null;

    /**
     * The constructor.
     * 
     * Only to be invoked by concrete sub classes.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param variation
     *            the parameter variation
     */
    protected MarkovSensitivity(final String name, final SensitivityParameterVariation variation) {
        this.name = name;
        if (variation != null) {
            this.variation = variation;
            this.numberOfSteps = calculator.calculateNumberOfSteps(variation);
        }
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected abstract boolean alterModel();

    /**
     * Assures a minimal number of three lines for the log headings.
     * 
     * @param list
     *            the log headings
     */
    private void assureLogHeadingsSize(final List<List<String>> list) {
        int numColumns = list.get(0).size();
        int numLines = list.size();
        if (numLines < 3) {
            for (int i = numLines; i < 3; i++) {
                ArrayList<String> newLine = new ArrayList<String>();
                for (int y = 0; y < numColumns; y++) {
                    newLine.add("");
                }
                list.add(0, newLine);
            }
        }
    }

    /**
     * Extracts the relevant sensitivity information from the given model.
     */
    protected abstract void extractSensitivityInformation();

    /**
     * Fills empty entries of the given log headings list.
     * 
     * @param list
     *            the log headings list
     */
    private void fillEmptyEntries(List<List<String>> list) {
        int numLines = list.size();
        int maxNumColumns = 0;
        for (int i = 0; i < numLines; i++) {
            if (list.get(i).size() > maxNumColumns) {
                maxNumColumns = list.get(i).size();
            }
        }
        for (int i = 0; i < numLines; i++) {
            for (int y = list.get(i).size(); y < maxNumColumns; y++) {
                list.get(i).add("");
            }
        }
    }

    /**
     * Finalizes the sensitivity analysis.
     */
    @Override
    public void finalize() {
        try {
            // Do the logging:
            for (int lineNumber = 0; lineNumber < logContents.size(); lineNumber++) {
                for (int index = 0; index < logContents.get(lineNumber).size(); index++) {
                    logWriter.append(logContents.get(lineNumber).get(index) + LOG_ENTRY_SEPARATOR);
                }
                logWriter.append(System.getProperty("line.separator"));
            }
            logWriter.flush();
            logWriter.close();
        } catch (IOException e) {
            LOGGER.error("Log file could not be written :" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the current step number.
     * 
     * @return the current step number
     */
    protected int getCurrentStepNumber() {
        return currentStepNumber;
    }

    /**
     * Returns the double parameter variation.
     * 
     * @return the double parameter variation
     */
    protected DoubleParameterVariation getDoubleVariation() {
        return (DoubleParameterVariation) variation;
    }

    /**
     * Builds the headings strings for logging.
     * 
     * @return the log headings strings
     */
    private List<List<String>> getLogHeadings() {

        // Create a result list:
        List<List<String>> resultList = getLogHeadingsMulti();

        // Assure that there are at least three lines of headings:
        assureLogHeadingsSize(resultList);
        for (UsageScenario scenario : model.getUsageModel().getUsageScenario_UsageModel()) {
            resultList.get(resultList.size() - 3).add(scenario.getEntityName());
            resultList.get(resultList.size() - 2).add("Success Probability");
            resultList.get(resultList.size() - 2).add("Failure Probability");
            resultList.get(resultList.size() - 1).add("");
            resultList.get(resultList.size() - 1).add("Total");
            for (int i = 0; i < resultSpecifications.size(); i++) {
                resultList.get(resultList.size() - 1).add(resultSpecifications.get(i).getEntityName());
            }
            fillEmptyEntries(resultList);
        }

        // Return the result:
        return resultList;
    }

    /**
     * Builds the headings strings for logging.
     * 
     * @return the log headings strings
     */
    protected abstract List<List<String>> getLogHeadingsMulti();

    /**
     * Builds the results strings for sensitivity logging.
     * 
     * @param markovResults
     *            the Markov transformation results
     * @return the results strings
     */
    protected List<String> getLogSingleResults(final List<MarkovTransformationResult> markovResults) {

        // Create a result list:
        List<String> resultList = getLogSingleResultsMulti();
        for (MarkovTransformationResult result : markovResults) {
            resultList.add(((Double) result.getSuccessProbability()).toString());
            resultList.add(((Double) (1.0 - result.getSuccessProbability())).toString());
            for (int i = 0; i < resultSpecifications.size(); i++) {
                resultList.add(((Double) calculator.calculateFailurePotential(result, resultSpecifications.get(i)))
                        .toString());
            }
        }

        // Return the result:
        return resultList;
    }

    /**
     * Builds the results string for sensitivity logging.
     * 
     * @return the results strings
     */
    protected abstract List<String> getLogSingleResultsMulti();

    /**
     * Retrieves the PCM instance.
     * 
     * @return the PCM instance
     */
    protected PCMInstance getModel() {
        return model;
    }

    /**
     * Retrieves the model to be used for the next step in the sensitivity analysis.
     * 
     * @return the model
     */
    public PCMInstance getNextModel() {

        // Check if there are still steps to perform:
        if (increaseCurrentStepNumber()) {
            return null;
        }

        // Perform the next step:
        if (!alterModel()) {
            LOGGER.error("PCM instance could not be successfully altered by Markov sensitivity analysis.");
            return null;
        } else {
            return model;
        }
    }

    /**
     * Returns the string parameter sequence.
     * 
     * @return the string parameter sequence
     */
    protected StringParameterSequence getStringSequence() {
        return (StringParameterSequence) variation;
    }

    /**
     * Increases the current step number.
     * 
     * @return indicates an overflow
     */
    protected boolean increaseCurrentStepNumber() {
        if (currentStepNumber < numberOfSteps) {
            currentStepNumber++;
            return false;
        }
        return true;
    }

    /**
     * Initializes the sensitivity analysis.
     * 
     * @param model
     *            the PCM instance
     */
    public void initialize(final PCMInstance model) {
        setModel(model);
        try {
            new File(resultLogfile).delete();
            logWriter = new BufferedWriter(new FileWriter(resultLogfile, false));
        } catch (IOException e) {
            LOGGER.error("Log file could not be initialized :" + e.getMessage());
            e.printStackTrace();
        }
        logContents = getLogHeadings();
    }

    /**
     * Logs the results of the current sensitivity analysis step.
     * 
     * @param markovResults
     *            the markov transformation results
     */
    public void logResults(final List<MarkovTransformationResult> markovResults) {
        logContents.add(getLogSingleResults(markovResults));
    }

    /**
     * Resets the current step number.
     * 
     */
    protected void resetCurrentStepNumber() {
        currentStepNumber = 1;
    }

    /**
     * Sets the result log file name.
     * 
     * @param logFileName
     *            the log file name
     */
    public void setLogFileName(final String logFileName) {
        this.resultLogfile = logFileName;
    }

    /**
     * Sets the PCM instance.
     * 
     * @param model
     *            the PCM instance
     */
    protected void setModel(final PCMInstance model) {
        this.model = model;
        extractSensitivityInformation();
    }

    /**
     * Specifies the relevant Markov analysis results.
     * 
     * @param resultSpecifications
     *            specification of results
     */
    public void setResultSpecifications(final EList<SensitivityResultSpecification> resultSpecifications) {
        this.resultSpecifications = resultSpecifications;
    }
}