package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.helper.GenotypeReader;
import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEProblem;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;

/**
 * Values need to be separated by a semicolon. 
 * @author Anne
 *
 */
public class GivenInstanceEvaluator extends PredefinedInstanceEvaluator {
	


	private ILaunchConfiguration configuration;
	public GivenInstanceEvaluator(ILaunchConfiguration configuration) throws CoreException {
		this.configuration = configuration;

	}

	protected List<DoubleGenotype> getGenotypes() throws CoreException{
		String filename = configuration.getAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES, "");
		return GenotypeReader.getGenotypes(filename); 
	}



}
