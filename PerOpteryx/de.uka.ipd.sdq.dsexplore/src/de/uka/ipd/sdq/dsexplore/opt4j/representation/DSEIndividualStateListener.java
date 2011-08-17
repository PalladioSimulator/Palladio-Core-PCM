package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.apache.log4j.Logger;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualStateListener;

import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

public class DSEIndividualStateListener implements IndividualStateListener {
	
	ResultsWriter writer;

	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualStateListener");
	
	public DSEIndividualStateListener(DSEWorkflowConfiguration dseConfig){
		this.writer = new ResultsWriter(dseConfig.getResultFolder()+"allIndividualsDirectly");
		Opt4JStarter.registerWriter(this.writer);
	}

	@Override
	public void inidividualStateChanged(Individual individual) {
		if (individual.getState() == Individual.State.EVALUATED){
			if (individual instanceof DSEIndividual){
				this.writer.writeIndividual((DSEIndividual)individual);
			} else {
				logger.error("There was an illegal individual that is not instance of DSEIndividual. Ignoring it. "+individual.toString());
			}
		}

	}

	@Override
	protected void finalize() throws Throwable {
		this.writer.close();
		super.finalize();
	}
	
	

}
