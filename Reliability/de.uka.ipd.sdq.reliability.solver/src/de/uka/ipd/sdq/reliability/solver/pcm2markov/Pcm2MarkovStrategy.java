package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.transformations.EMFHelper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReporting;
import de.uka.ipd.sdq.reliability.solver.sensitivity.MarkovSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.MarkovSensitivityBuilder;
import de.uka.ipd.sdq.reliability.solver.visualisation.MarkovHtmlGenerator;
import de.uka.ipd.sdq.reliability.solver.visualisation.MarkovResultEditorInput;

/**
 * This class performs a transformation from a PCM instance to a Markov Chain instance, and solves
 * the resulting Markov Chain instance.
 * 
 * @author brosch
 * 
 */
public class Pcm2MarkovStrategy implements SolverStrategy {

    /**
     * Configuration properties for the reliability solver workflow.
     */
    private PCMSolverWorkflowRunConfiguration configuration;

    /**
     * The Markov transformation results (one result object for each PCM UsageScenario).
     */
    private List<MarkovTransformationResult> markovResults;

    /**
     * Captures a configuration for sensitivity analysis (temporary).
     */
    private MarkovSensitivity markovSensitivity;

    /**
     * The constructor.
     * 
     * @param configuration
     *            launch configuration parameters
     */
    public Pcm2MarkovStrategy(final PCMSolverWorkflowRunConfiguration configuration) {
        this.configuration = configuration;
        this.markovSensitivity = initSensitivityAnalysis();
    }

    /**
     * Retrieves the Markov transformation results.
     * 
     * If the PCM instance has multiple usage scenarios, only the results for the first usage
     * scenario are returned.
     * 
     * @return the Markov transformation results
     */
    public MarkovTransformationResult getSolvedValue() {
        return (markovResults.size() > 0) ? markovResults.get(0) : null;
    }
    
    public List<MarkovTransformationResult> getAllSolvedValues() {
        return markovResults;
    }

    /**
     * Initializes sensitivity analysis parameters.
     * 
     * @return the sensitivity configuration; NULL if no sensitivity analysis shall be performed
     */
    private MarkovSensitivity initSensitivityAnalysis() {
        if (configuration.isSensitivityModelEnabled()) {
            MarkovSensitivityBuilder builder = new MarkovSensitivityBuilder();
            return builder.buildSensitivity(resolveFile(configuration.getSensitivityModelFileName()),
                    resolveFile(configuration.getSensitivityLogFileName()));
        }
        return null;
    }

    /**
     * Loads an already existing Markov Chain from a given XMI file. Not yet implemented.
     * 
     * @param fileName
     *            the name of the XMI file
     */
    public void loadTransformedModel(final String fileName) {
        throw new UnsupportedOperationException();
    }

    /**
     * Resolves a file's path in case it starts with "platform:/" and returns the entire absolute
     * path to the file, including the file's name.
     * 
     * @param fileURL
     *            the path to a file, including the file's name (and its extension)
     * @return the absolute path to the file, including the file's name
     */
    private String resolveFile(String fileURL) {
        // if this is a platform URL, first resolve it to an absolute path
        if (fileURL.startsWith("platform:")) {
            try {
                URL solvedURL = FileLocator.resolve(new URL(fileURL));
                fileURL = solvedURL.getPath();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return fileURL;
    }

    /**
     * Saves the given String (HTML code) to a file specified in the configuration.
     * 
     * @param htmlCode
     *            the (HTML code) string to save
     */
    private void saveResultsToFile(String htmlCode) {
        BufferedWriter out = null;
        String filePath = resolveFile(configuration.getSaveFile());
        try {
            File f = new File(filePath);
            // if the file exists, we will delete it and create a new,
            // empty one (i.e., overwrite the existing file) once, and then
            // repeatedly append to this file
            if (f.exists()) {
                f.delete(); // delete current (old) file
                f.createNewFile(); // create a new, empty file
            }
            out = new BufferedWriter(new FileWriter(filePath, true));
            out.append(htmlCode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Shows the Markov transformation results in the workbench editor of the target instance, given
     * HTML code, represented as string.
     * 
     * @param htmlCode
     *            the HTML code as string
     */
    private void showResults(final String htmlCode) {
        if (markovResults != null) {
            Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    if (page != null) {
                        try {
                            page.openEditor(new MarkovResultEditorInput(htmlCode),
                                    "de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovResultEditor");
                        } catch (PartInitException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /**
     * Solves the Markov Chain which has been created as a result of the transformation or has been
     * loaded from an XMI file.
     */
    public void solve() {

        // Solving of Markov Chain has already taken place during the
        // transformation.

    }

    /**
     * Saves the Markov Chain resulting from the transformation into an XMI file.
     * 
     * If the PCM instance has multiple usage scenarios, only the results for the first usage
     * scenario are written into the file.
     * 
     * @param fileName
     *            the name of the XMI file to create
     */
    public void storeTransformedModel(final String fileName) {
        MarkovTransformationResult result = (markovResults.size() > 0) ? markovResults.get(0) : null;
        if (result != null) {
            EMFHelper.saveToXMIFile(result.getResultChain(), resolveFile(fileName));
        }
    }

    /**
     * Transforms a PCM instance into a Markov Chain instance.
     * 
     * The transformation is performed either as a single transformation, or as a repeated
     * transformation to perform sensitivity analysis.
     * 
     * @param model
     *            the input PCM instance
     */
    public void transform(final PCMInstance model) {
        markovResults = new MarkovTransformation().runTransform(model, configuration, markovSensitivity);
        if (configuration.isMarkovModelStorageEnabled()) {
            storeTransformedModel(configuration.getMarkovModelFile());
        }

        // embed results in HTML page
        String htmlCode = new MarkovHtmlGenerator(new MarkovReporting(markovResults, configuration)).getHtml();
        // check whether the HTML page containing the results shall be saved to
        // a file
        if (configuration.isSaveResultsToFileEnabled()) {
            saveResultsToFile(htmlCode);
        } // else do nothing

        // show the HTML page containing the results
        if (configuration.isShowHtmlResults()) {
            showResults(htmlCode);
        }
    }
}