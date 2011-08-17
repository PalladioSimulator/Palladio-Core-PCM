package de.uka.ipd.sdq.dsexplore.analysis.simucom.tests;

import java.util.Properties;

import de.uka.ipd.sdq.dsexplore.analysis.simucom.SimuComAnalysisResult;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentRunImpl;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import junit.framework.TestCase;

public class SimuComAnalysisResultTest extends TestCase {

	private SimuComAnalysisResult scr;

	public SimuComAnalysisResultTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		ExperimentRun run = new ExperimentRunImpl(null);
		Properties config = new Properties();
		PCMInstance pcmInstance = new PCMInstance(config);
		Experiment exp = new ExperimentImpl(null);
		
		//FIXME: add proper params
		scr = new SimuComAnalysisResult(run, exp, pcmInstance, null, null, null);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetUtilisationOfResource() {
		//scr.getUtilisationOfResource(null, null);
		fail("Not yet implemented");
	}

}


