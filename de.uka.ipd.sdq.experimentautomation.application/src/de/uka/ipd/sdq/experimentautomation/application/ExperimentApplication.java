package de.uka.ipd.sdq.experimentautomation.application;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.experimentautomation.application.controller.ExperimentController;
import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;

public class ExperimentApplication implements IApplication {

    private static final Logger logger = Logger.getLogger(ExperimentApplication.class);
    
    private ConfigurationModel config;

    @Override
    public Object start(final IApplicationContext context) throws Exception {
        // obtain command line arguments
        final String[] args = (String[]) context.getArguments().get("application.args");

        // check arguments
        if (args.length < 3) {
            System.out.println("The mandatory parameters have not been specified.");
            return IApplication.EXIT_OK;
        }
        
        // prepare experiment list, if parameter has been specified 
        List<String> experimentIds = new ArrayList<String>();
        if (args.length >= 4) {
            String[] ids = args[3].split(";");
            for(int i = 0; i<ids.length; i++) {
                experimentIds.add(ids[i]);
            }
        }

        // load configuration
        final Bundle bundle = Activator.getDefault().getBundle();
        final Path experimentsLocation = new Path(args[0]);
        final Path variationsLocation = new Path(args[1]);
        final Path bookkeepingLocation = new Path(args[2]);
        this.config = ConfigurationModel.loadFromBundle(bundle, experimentsLocation, variationsLocation);

        // filter experiment list
        List<Experiment> filteredExperiments = new ArrayList<Experiment>();
        for(Experiment e : this.config.getExperiments().getExperiments()) {
            for(String id : experimentIds) {
                if(e.getId().equalsIgnoreCase(id)) {
                    filteredExperiments.add(e);
                    break;
                }
            }
        }
        
        // run experiments
        final ExperimentController controller = new ExperimentController(this.config, experimentsLocation, variationsLocation, bookkeepingLocation, args);
        
        int repetitions = this.config.getExperiments().getRepetitions();
        if(experimentIds.isEmpty()) {
            controller.runExperiments(repetitions); 
        } else {
            controller.runExperiment(filteredExperiments, repetitions);
        }
        

        return IApplication.EXIT_OK;
    }

    @Override
    public void stop() {
        // nothing to do
    }

}
