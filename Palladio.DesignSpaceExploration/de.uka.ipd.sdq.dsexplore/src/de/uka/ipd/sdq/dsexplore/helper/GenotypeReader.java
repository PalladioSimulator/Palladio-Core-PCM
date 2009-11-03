package de.uka.ipd.sdq.dsexplore.helper;

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
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEProblem;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;

public class GenotypeReader {
	
	private static final String SEPARATOR = ";";

	public static List<DoubleGenotype> getGenotypes(String filename) throws CoreException{
		File file = new File(filename);
		
	    try {
	    	
	    	List<DoubleGenotype> results = null;
	    	
	    	boolean isRaw = isRawFileType(getReaderFor(file));
	    	
	    	if (isRaw){
	    		results = readInRawGenotypes(getReaderFor(file));
	    	} else {
	    		results = readInPrettyPrintedGenotypes(getReaderFor(file));
	    	}

	        
	        return results;
	        
	      } catch( Exception ex ) {
	        throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, "Could not evaluate predefined instances. Leave field blank for evolutionary search or type \"random\" for a random search."+ex.getMessage(), ex));
	      }
	}
	private static BufferedReader getReaderFor(File file) throws FileNotFoundException {
    	InputStreamReader ir = new InputStreamReader(
                new FileInputStream( file ) );
        BufferedReader in = new BufferedReader(ir);
		return in;
	}

	/**
	 * Checks whether the given file contains just double values or a pretty 
	 * print of the design options, as printed with 
	 * {@link ResultsWriter#writeIndividualsToFile(java.util.Collection, String, int, List)} 
	 * @param in Is used and modify and closed 
	 * @return
	 * @throws IOException 
	 * @throws CoreException 
	 */
	private static boolean isRawFileType(final BufferedReader in) throws IOException, CoreException {
		boolean isRaw = false;
		
		//headline might contain strings anyway
		String headline = in.readLine(); 
		String secondLine = in.readLine();
		
		if (secondLine != null){
			isRaw = isLineOfDoublesOnly(secondLine); 
		} else if (headline != null){
			//if second line is empty, there could be a single raw instance in the file
			isRaw = isLineOfDoublesOnly(headline);
		} else throw new CoreException(new Status(Status.ERROR,
				"de.uka.ipd.sdq.dsexplore", 0, "Predefined instances file could not be read because it is empty. Specify a valid file or \"random\" or leave the field blank for an evolutionary search.", null));
	
		in.close();

		return isRaw;
	}

	/**
	 * 
	 * @param line
	 * @return
	 */
	private static boolean isLineOfDoublesOnly(String line) {
		boolean isDoubleLine = true;
		String[] lineArray = line.split(SEPARATOR);
		
		//try all values in the line
    	try {
        	for (String string : lineArray) {
				Double.parseDouble(string);
			}
    	} catch (NumberFormatException e){
    		isDoubleLine = false;
    	}
		return isDoubleLine;
	}

	/**
	 * 
	 * @param in Is used and modify and closed 
	 * @return
	 * @throws CoreException
	 * @throws IOException
	 */
	private static List<DoubleGenotype> readInPrettyPrintedGenotypes(BufferedReader in) throws CoreException, IOException {
		List<DoubleGenotype> results = new ArrayList<DoubleGenotype>();
		
		DSEProblem problem = Opt4JStarter.problem;
		List<DegreeOfFreedom> decisionList = problem.getDesignDecisions();
		
		//order design decisions
		String headline = in.readLine();
		if (headline == null){
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, "Predefined instances file could not be read because it is empty. Specify a valid file or \"random\" or leave the field blank for an evolutionary search.", null));
		} 
		String[] headlineArray = headline.split(SEPARATOR);
		
		List<DegreeOfFreedom> orderedDesignDecisions = new ArrayList<DegreeOfFreedom>();
		for (String headlineEntry : headlineArray) {
			for (DegreeOfFreedom decision : decisionList) {
				if (decision.toString().equals(headlineEntry)){
					orderedDesignDecisions.add(decision);
				}
			}
		}
		//set the internal design decisions to the same order
		problem.getDesignDecisions().clear();
		problem.getDesignDecisions().addAll(orderedDesignDecisions);
		
		String line;
		while ( null != (line = in.readLine()) ) {
			String[] lineArray = line.split(SEPARATOR);
			//Check length, a last semicolon is ok that makes the line array one longer than the list.
			if (lineArray.length != orderedDesignDecisions.size()+1 && lineArray.length != orderedDesignDecisions.size()){
				throw new CoreException(new Status(Status.ERROR,
						"de.uka.ipd.sdq.dsexplore", 0, "A line in the predefined instances file has not the right length", null));
			}
			DoubleGenotype genotype = new DoubleGenotype(Opt4JStarter.problem.getBounds());
			for (int i = 0; i < lineArray.length; i++) {
				double gene = DSEDecoder.getDoubleValueFor(lineArray[i], orderedDesignDecisions.get(i));
				genotype.add(gene);
			}
			results.add(genotype);
			
		}
		in.close();
		
		return results;
	}

	/**
	 * 
	 * @param in Is used and modify and closed 
	 * @return
	 * @throws IOException
	 */
	private static List<DoubleGenotype> readInRawGenotypes(BufferedReader in) throws IOException {
		List<DoubleGenotype> results = new ArrayList<DoubleGenotype>();
    	String line = "";
        while( null != (line = in.readLine()) ) {
        	DoubleGenotype genotype = new DoubleGenotype(Opt4JStarter.problem.getBounds());
        	String[] lineArray = line.split(SEPARATOR);
        	try {
	        	for (String string : lineArray) {
					Double gene = Double.parseDouble(string);
					genotype.add(gene);
				}
	        	results.add(genotype);
        	} catch (NumberFormatException e){
        		//skip this line
        		continue;
        	}
        }
        in.close();
		return results;
	}


}
