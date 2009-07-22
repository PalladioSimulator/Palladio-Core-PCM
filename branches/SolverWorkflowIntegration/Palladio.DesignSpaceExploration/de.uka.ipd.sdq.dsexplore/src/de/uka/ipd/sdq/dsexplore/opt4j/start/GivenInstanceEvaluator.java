package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;


public class GivenInstanceEvaluator extends PredefinedInstanceEvaluator {

	private ILaunchConfiguration configuration;
	public GivenInstanceEvaluator(ILaunchConfiguration configuration) throws CoreException {
		this.configuration = configuration;
		


	}

	protected List<DoubleGenotype> getGenotypes() throws CoreException{
		String filename = configuration.getAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES, "");
		File file = new File(filename);
		
	    try {
	    	String line = "";
	    	List<DoubleGenotype> results = new ArrayList<DoubleGenotype>();
	        BufferedReader in = new BufferedReader(
	                            new InputStreamReader(
	                            new FileInputStream( file ) ) );
	        while( null != (line = in.readLine()) ) {
	        	DoubleGenotype genotype = new DoubleGenotype();
	        	String[] lineArray = line.split(";");
	        	for (String string : lineArray) {
					Double gene = Double.parseDouble(string);
					genotype.add(gene);
				}
	        	results.add(genotype);
	        }
	        in.close();
	        
	        return results;
	        
	      } catch( Exception ex ) {
	        throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, ex.getMessage(), ex));
	      }
	}

}
