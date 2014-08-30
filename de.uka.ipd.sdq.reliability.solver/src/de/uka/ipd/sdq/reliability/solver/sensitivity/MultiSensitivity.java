package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

/**
 * Provides a possibility to define multiple sensitivity parameters to be defined within one
 * sensitivity analysis.
 * 
 * @author brosch
 * 
 */
public class MultiSensitivity extends MarkovSensitivity {

    /**
     * Determines if all combinations of parameter values shall be examined.
     */
    private boolean isCombinatory;

    /**
     * List of sensitivity parameters.
     */
    public List<MarkovSensitivity> sensitivityParameters;

    /**
     * The constructor.
     * 
     * @param name
     *            name of the sensitivity analysis
     * @param sensitivityParameters
     *            list of sensitivity parameters
     * @param isCombinatory
     *            indicates if all combinations of sensitivity parameters shall be examined
     */
    public MultiSensitivity(final String name, final List<MarkovSensitivity> sensitivityParameters,
            final boolean isCombinatory) {

        // Initialize basic variables:
        super(name, null);

        // Further initializations:
        this.sensitivityParameters = sensitivityParameters;
        this.isCombinatory = isCombinatory;

        // Determine the overall number of sensibility steps:
        determineNumberOfSteps();
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected boolean alterModel() {

        // Control the model alteration proceeds as required:
        boolean modelAltered = false;

        // In the non-combinatory case, let each sensitivity parameter alter the
        // model:
        if (!isCombinatory) {
            for (MarkovSensitivity sensitivity : sensitivityParameters) {
                if (sensitivity.alterModel() == true) {
                    modelAltered = true;
                }
            }
        }

        // In the combinatory case, increase the overall step counter over all
        // sensitivity parameters:
        if (isCombinatory && (sensitivityParameters.size() > 0)) {
            for (MarkovSensitivity sensitivity : sensitivityParameters) {
                if (sensitivity.alterModel() == true) {
                    modelAltered = true;
                }
            }
        }

        // Everything ok:
        return modelAltered;
    }

    /**
     * Determines the overall number of sensitivity analysis steps.
     */
    private void determineNumberOfSteps() {
        numberOfSteps = (isCombinatory) ? 1 : 0;
        for (MarkovSensitivity sensitivity : sensitivityParameters) {
            if (!isCombinatory) {
                if (sensitivity.numberOfSteps > numberOfSteps) {
                    numberOfSteps = sensitivity.numberOfSteps;
                }
            } else {
                numberOfSteps *= sensitivity.numberOfSteps;
            }
        }
    }

    /**
     * Extracts the relevant sensitivity information from the given model.
     */
    protected void extractSensitivityInformation() {
        // Nothing to do in the MultiSensitivity.
    }

    /**
     * Retrieves the current step number.
     * 
     * @return the current step number
     */
    protected int getCurrentStepNumber() {
        if (isCombinatory) {
            int stepNumber = 1;
            for (int i = 0; i < sensitivityParameters.size(); i++) {
                int step = sensitivityParameters.get(i).getCurrentStepNumber();
                if (step == 0) {
                    return 0;
                }
                int weight = 1;
                for (int j = i + 1; j < sensitivityParameters.size(); j++) {
                    weight *= sensitivityParameters.get(j).numberOfSteps;
                }
                stepNumber += weight * (step - 1);
            }
            return stepNumber;
        } else {
            int stepNumber = 0;
            for (MarkovSensitivity sensitivity : sensitivityParameters) {
                stepNumber = Math.max(stepNumber, sensitivity.getCurrentStepNumber());
            }
            return stepNumber;
        }
    }

    /**
     * Builds the headings strings for logging.
     * 
     * @return the log headings strings
     */
    protected List<List<String>> getLogHeadingsMulti() {

        // Create a result list:
        List<List<String>> resultList = new ArrayList<List<String>>();

        // Build the lines of the result list:
        ArrayList<String> newHeadings = new ArrayList<String>();
        ArrayList<List<List<String>>> existingHeadings = new ArrayList<List<List<String>>>();
        for (MarkovSensitivity sensitivity : sensitivityParameters) {
            existingHeadings.add(sensitivity.getLogHeadingsMulti());
        }
        resultList.add(newHeadings);
        for (int i = 0; i < getMaxNumberOfLines(existingHeadings); i++) {
            resultList.add(new ArrayList<String>());
        }

        // Fill the lines of the result list:
        for (int i = 0; i < existingHeadings.size(); i++) {
            int numberOfColums = 0;
            for (int j = 0; j < existingHeadings.get(i).size(); j++) {
                numberOfColums = existingHeadings.get(i).get(j).size();
                int resultIndex = resultList.size() - existingHeadings.get(i).size() + j;
                resultList.get(resultIndex).addAll(existingHeadings.get(i).get(j));
            }
            newHeadings.add(sensitivityParameters.get(i).name);
            for (int j = 0; j < resultList.size() - existingHeadings.get(i).size(); j++) {
                for (int k = ((j == 0) ? 1 : 0); k < numberOfColums; k++) {
                    resultList.get(j).add("");
                }
            }
        }

        // Return the result:
        return resultList;
    }

    /**
     * Builds the results strings for sensitivity logging.
     * 
     * @return the results strings
     */
    protected List<String> getLogSingleResultsMulti() {

        // Create a result list:
        List<String> resultList = new ArrayList<String>();

        // Create the result strings:
        for (MarkovSensitivity sensitivity : sensitivityParameters) {
            resultList.addAll(sensitivity.getLogSingleResultsMulti());
        }

        // Return the result:
        return resultList;
    }

    /**
     * Determines the number of lines in the given list of log headings.
     * 
     * @param logHeadingsList
     *            the list of log headings
     * @return the number of lines
     */
    private int getMaxNumberOfLines(ArrayList<List<List<String>>> logHeadingsList) {
        int maxNumberOfLines = 0;
        for (int i = 0; i < logHeadingsList.size(); i++) {
            int numberOfLines = logHeadingsList.get(i).size();
            maxNumberOfLines = Math.max(numberOfLines, maxNumberOfLines);
        }
        return maxNumberOfLines;
    }

    /**
     * Retrieves the current step count of a sensitivity parameter.
     * 
     * @param index
     *            the index of the {@link SensitivityStatus} parameter
     * @return the step count
     */
    private int getStepCount(final int index) {
        MarkovSensitivity sensitivity = sensitivityParameters.get(index);
        return sensitivity.getCurrentStepNumber();
    }

    /**
     * Increases the current step number.
     * 
     * @return indicates an overflow
     */
    protected boolean increaseCurrentStepNumber() {
        if (isCombinatory) {
            if (sensitivityParameters.size() > 0) {
                return increaseStepCountRecursively(0);
            }
            return true;
        } else {
            boolean overflow = true;
            for (MarkovSensitivity sensitivity : sensitivityParameters) {
                if (!sensitivity.increaseCurrentStepNumber()) {
                    overflow = false;
                }
            }
            return overflow;
        }
    }

    /**
     * Increases the combinatory step count of a sensitivity parameter.
     * 
     * @param index
     *            the index of sensitivity parameter
     * @return true if an overflow happened
     */
    private boolean increaseStepCount(final int index) {
        MarkovSensitivity sensitivity = sensitivityParameters.get(index);
        if (!sensitivity.increaseCurrentStepNumber()) {
            for (int i = index + 1; i < sensitivityParameters.size(); i++) {
                sensitivityParameters.get(i).resetCurrentStepNumber();
            }
            return false;
        }
        return true;
    }

    /**
     * Increases the combinatory step count over all sensitivity parameters.
     * 
     * @param index
     *            the index of the current sensitivity parameter
     * @return true if an overflow happened
     */
    private boolean increaseStepCountRecursively(final int index) {

        // Check for the cases of the recursion:
        if (getStepCount(index) == 0) {
            // Initial case, all step counts set to 1:
            initStepCountRecusively(index);
            return false;
        } else if (sensitivityParameters.size() > index + 1) {
            // Recursive case, increase counter:
            if (increaseStepCountRecursively(index + 1)) {
                return increaseStepCount(index);
            }
            return false;
        } else {
            // Base case, increase last counter:
            return increaseStepCount(index);
        }
    }

    /**
     * Initializes all sensitivity parameter step counts to 1.
     * 
     * @param index
     *            the index of the current sensitivity parameter
     */
    private void initStepCountRecusively(final int index) {
        if (sensitivityParameters.size() > index) {
            MarkovSensitivity sensitivity = sensitivityParameters.get(index);
            sensitivity.resetCurrentStepNumber();
            initStepCountRecusively(index + 1);
        }
    }

    /**
     * Resets the current step number.
     * 
     */
    protected void resetCurrentStepNumber() {
        for (MarkovSensitivity sensitivity : sensitivityParameters) {
            sensitivity.resetCurrentStepNumber();
        }
    }

    /**
     * Sets the PCM instance.
     * 
     * @param model
     *            the PCM instance
     */
    protected void setModel(final PCMInstance model) {
        super.setModel(model);
        for (MarkovSensitivity sensitivity : sensitivityParameters) {
            sensitivity.setModel(model);
        }
    }
}
