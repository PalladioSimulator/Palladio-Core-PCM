package de.uka.ipd.sdq.experimentautomation.application.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.experimentautomation.application.Activator;
import de.uka.ipd.sdq.experimentautomation.application.ConfigurationModel;
import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;
import de.uka.ipd.sdq.experimentautomation.application.ExperimentMetadata;
import de.uka.ipd.sdq.experimentautomation.application.measurement.IResponseMeasurement;
import de.uka.ipd.sdq.experimentautomation.application.measurement.ResponseMeasurementFactory;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.AnalysisToolFactory;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.IToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.utils.PCMModelHelper;
import de.uka.ipd.sdq.experimentautomation.application.utils.Utils;
import de.uka.ipd.sdq.experimentautomation.application.variation.IVariationStrategy;
import de.uka.ipd.sdq.experimentautomation.application.variation.VariationStrategyFactory;
import de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider.IValueProviderStrategy;
import de.uka.ipd.sdq.experimentautomation.application.variation.valueprovider.ValueProviderFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.Variation;

public class ExperimentController {

    private static final Logger logger = Logger.getLogger(ExperimentController.class);

    private static final boolean ZIP_AND_UPLOAD_RESULTS_WHEN_FINISHED = false;
    
    private Bundle bundle;
    private ConfigurationModel config;
    private Path experimentsLocation;
    private Path variationsLocation;
    private Path bookkeepingLocation;
    private String args[];
    private List<IRunListener> listeners;
	private boolean copyAuxModelFiles;

    /**
     * 
     * @param config
     * @param args
     *            the command line arguments passed to this application
     */
    public ExperimentController(ConfigurationModel config, Path experimentsLocation, Path variationsLocation,
            Path bookkeepingLocation, String[] args) {
        this.bundle = Activator.getDefault().getBundle();
        this.config = config;
        this.experimentsLocation = experimentsLocation;
        this.variationsLocation = variationsLocation;
        this.bookkeepingLocation = bookkeepingLocation;
        this.args = args;
        this.listeners = new ArrayList<IRunListener>();
		this.copyAuxModelFiles = true;
	}

	public ExperimentController(Path bookkeepingLocation) {
		this.bookkeepingLocation = bookkeepingLocation;
		this.args = new String[] { "none (call by code)" };
		this.copyAuxModelFiles = false;
	}


    private IVariationStrategy initialiseVariations(Variation v, ResourceSet rs) {
        EObject variedObject = PCMModelHelper.findModelElementById(rs, v.getVariedObjectId());
        IVariationStrategy s = VariationStrategyFactory.createStrategy(v.getType());
        s.setVariedObject(variedObject);
        return s;
    }

	public void runExperiment(Experiment experiment) {
		List<Experiment> experiments = new ArrayList<Experiment>(1);
		experiments.add(experiment);
		runExperiment(experiments, 1);
	}

    public void runExperiment(List<Experiment> experiments, int repetitions) {
        for (Experiment exp : experiments) {
            for (ToolConfiguration c : exp.getToolConfiguration()) {
                runExperiment(exp, c, repetitions);
            }
        }
    }

    public void runExperiments(int repetitions) {
        runExperiment(config.getExperiments().getExperiments(), repetitions);
    }

    private void runExperiment(Experiment exp, ToolConfiguration toolConfig, int repetitions) {
        String experimentName = "(" + exp.getId() + ", " + toolConfig.getName() + ") " + exp.getName();
        File experimentFolder = new File(bookkeepingLocation.toOSString() + File.separator + experimentName + " ("
                + System.currentTimeMillis() + ")" + File.separator);
        ExperimentBookkeeping bookkeeping = new ExperimentBookkeeping(experimentFolder);
        ExperimentMetadata metadata = new ExperimentMetadata();
        metadata.setExperimentName(experimentName);
        metadata.setStartTime(new Date());
        metadata.setCommandLineArguments(args);
        metadata.setVirtualMachineArguments("TODO");

        String[] factorNames = new String[exp.getVariations().size()];
        for (int i = 0; i < factorNames.length; i++) {
            factorNames[i] = exp.getVariations().get(i).getName();
        }
        IResponseMeasurement m = ResponseMeasurementFactory.createResponseMeasurement(exp.getResponseMeasurement(), bookkeeping, null, null);         // TODO
        m.prepareBookkeeping(bookkeeping, factorNames);


        ExperimentContext settings = new ExperimentContext(bookkeeping, experimentName, experimentFolder, toolConfig,
                repetitions, exp);
        runExperiments(exp.getVariations(), settings, new ArrayList<Variation>(), new ArrayList<Long>());

        bookkeeping.finishResultFile();
        metadata.setEndTime(new Date());
        bookkeeping.writeMetadata(metadata);

		// TODO the zip-and-upload feature has not been test after a recrent refactoring. If you want to use it, be 
        // aware of this and better use a debugger the first time. 
        if(ZIP_AND_UPLOAD_RESULTS_WHEN_FINISHED) {
	        // name of zip file to create
	        String zipFileName = experimentName + ".zip";
	        
	        // location of zip to create 
	        File zipFile = new File(experimentFolder.getParent() + File.separator + zipFileName);
	        
	        String hostName = "YOUR_HOST";
	        String user = "YOUR_USER";
	        String password = "YOUR_PASSWORD";
	        
	        Utils.zipFolder(experimentFolder, zipFile);
	        Utils.ftpUpload(hostName, user, password, zipFile, zipFileName);
        }
    }

    

    private class ExperimentContext {

        private ExperimentBookkeeping bookkeeping;
        private String experimentName;
        private File experimentFolder;
        private ToolConfiguration toolConfiguration;
        private int repetitions;
        private Experiment experiment;

        public ExperimentContext(ExperimentBookkeeping bookkeeping, String experimentName, File experimentFolder,
                ToolConfiguration toolConfiguration, int repetitions, Experiment experiment) {
            super();
            this.bookkeeping = bookkeeping;
            this.experimentName = experimentName;
            this.experimentFolder = experimentFolder;
            this.toolConfiguration = toolConfiguration;
            this.repetitions = repetitions;
            this.experiment = experiment;
        }

        public ExperimentBookkeeping getBookkeeping() {
            return bookkeeping;
        }

        public String getExperimentname() {
            return experimentName;
        }

        public File getExperimentFolder() {
            return experimentFolder;
        }

        public ToolConfiguration getToolConfiguration() {
            return toolConfiguration;
        }

        public int getRepetitions() {
            return repetitions;
        }

        public Experiment getExperiment() {
            return experiment;
        }

    }

    public void runExperiments(List<Variation> list, ExperimentContext settings, List<Variation> variants,
            List<Long> currentFactorLevels) {
        if (!list.isEmpty()) {
            // obtain variation description
            List<Variation> copy = new ArrayList<Variation>();
            copy.addAll(list);
            Variation variation = copy.remove(0);

            // obtain value provider
            IValueProviderStrategy valueProvider = ValueProviderFactory.createValueProvider(variation
                    .getValueProvider());

            long factorLevel = 0;
            int iteration = 0;
            while (factorLevel <= variation.getMaxValue() && iteration < variation.getMaxVariations()) {
                factorLevel = valueProvider.valueAtPosition(iteration);
                if (factorLevel == -1) {
                    break;
                }

                if (factorLevel >= variation.getMinValue() && factorLevel <= variation.getMaxValue()) {
                    variants.add(variation);
                    currentFactorLevels.add(factorLevel);

                    runExperiments(copy, settings, variants, currentFactorLevels);

                    variants.remove(variants.size() - 1);
                    currentFactorLevels.remove(currentFactorLevels.size() - 1);
                }

                iteration++;
            }
        } else {
            variateModelAndSimulate(settings, variants, currentFactorLevels);
        }
    }

    private void variateModelAndSimulate(ExperimentContext settings, List<Variation> variations, List<Long> factorLevels) {
        Experiment exp = settings.getExperiment();

        // build experiment folder URI
        String factorLevelsString = "";
        for (int i = 0; i < factorLevels.size(); i++) {
            factorLevelsString += variations.get(i).getName() + "=" + factorLevels.get(i);
            if (i + 1 < factorLevels.size())
                factorLevelsString += ", ";
        }
        URI variationFolderUri = URI.createFileURI(settings.getExperimentFolder().toString() + "/" + factorLevelsString
                + "/");

        // copy initial PCM model files to experiment folder
		PCMModelFiles modelCopy;
		if (copyAuxModelFiles) {
			modelCopy = PCMModelHelper.copyToExperimentFolder(exp.getInitialModel(), experimentsLocation, variationsLocation, variationFolderUri);
		} else {
			modelCopy = PCMModelHelper.copyToExperimentFolder(exp.getInitialModel(), variationFolderUri);
		}

        // load PCM model from copied model files
        final ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResource(URI.createFileURI(modelCopy.getUsagemodelFile()), true);
        resourceSet.getResource(URI.createFileURI(modelCopy.getAllocationFile()), true);
        EcoreUtil.resolveAll(resourceSet);

        // modify the copied PCM model according to the variation descriptions
        List<String> variationDescriptions = new ArrayList<String>();
        for (int i = 0; i < variations.size(); i++) {
            Variation v = variations.get(i);
            long currentValue = factorLevels.get(i);
            IVariationStrategy variationStrategy = initialiseVariations(v, resourceSet);
            String desc = variationStrategy.vary(currentValue);
            variationDescriptions.add(desc);
        }

        // save the varied PCM model
        try {
            saveResources(resourceSet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // simulate the varied PCM model one or more times as specified by the replication count
        for (int i = 1; i <= settings.getRepetitions(); i++) {
//            ISimulationListener l = new SimulationDurationSimulationListener(settings.getBookkeeping(), factorLevels);
            IResponseMeasurement m = ResponseMeasurementFactory.createResponseMeasurement(exp.getResponseMeasurement(), settings.getBookkeeping(), factorLevels, variationFolderUri);
            try {
                IToolAdapter analysisTool = AnalysisToolFactory.createToolAdapater(settings.getToolConfiguration());
                analysisTool.runExperiment(settings.getExperimentname() + " "
                        + settings.getToolConfiguration().getName(), modelCopy, settings.getToolConfiguration(),
                        settings.getExperiment().getStopConditions(), m);
            } catch (Exception ex) {
                settings.getBookkeeping().logException(ex);
            }
        }
    }

    public void addListener(IRunListener l) {
        this.listeners.add(l);
    }

    public void removeListener(IRunListener l) {
        this.listeners.remove(l);
    }

    private void notifyBeforeListener() {
        for (IRunListener l : listeners) {
            l.beforeRun();
        }
    }

    private void notifyAfterListener() {
        for (IRunListener l : listeners) {
            l.afterRun();
        }
    }

    private void saveResources(ResourceSet rs) throws IOException {
        for (Resource r : rs.getResources()) {
            URI n = rs.getURIConverter().normalize(r.getURI());
            if (n.isFile()) {
                OutputStream out = rs.getURIConverter().createOutputStream(r.getURI());
                r.save(out, null);
                logger.info("Saving resource: " + r.toString());
            }
        }
    }

}
