package de.uka.ipd.sdq.dsexplore.helper;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.opt4j.core.Constraint;
import org.opt4j.core.Criterion;
import org.opt4j.core.Individual;
import org.opt4j.core.IntegerValue;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;

import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.ITactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEObjectives;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EntryLevelSystemCallCriterion;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedCriterion;
import de.uka.ipd.sdq.dsexplore.qml.pcm.reader.PCMDeclarationsReader;
import de.uka.ipd.sdq.pcm.designdecision.Candidates;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

/**
 * XXX: Maybe make this a proper label provider for the results? Metamodel results?
 * 
 * After calling close(), the ResultWriter should not be used anymore, because it will have closed its internal writer and set the reference to null. Any further logs are written to Log4J.
 *  
 * @author Anne
 *
 */
public class ResultsWriter {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.ResultsWriter");
	//
	// Part for heuristics
	//
	/**
	 * Formating string used for logging purposes
	 */
	private static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	private String myfilename;
	FileWriter fileWriter;
	private List<Criterion> criteriaToSave;
	private List<Criterion> criteriaWithConfidence;
	
	public ResultsWriter(String filename) {
		this.myfilename = filename+"_"+getTimeDateString()+".csv";
		try {
			this.fileWriter = new FileWriter(myfilename);
		} catch (IOException e) {
			logger.error("Cannot write to file "+myfilename+" to store individuals. I will print them to the logger instead. Cause: "+e.getMessage());
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * Write all individuals to new file (file current time in filename).
	 * @param individuals
	 * @param filename
	 * @param iteration
	 * @param exceptionList
	 */
	public static void writeDSEIndividualsToFile(Collection<DSEIndividual> individuals, String filename, int iteration, boolean asEMF,
			boolean asCVS, List<Exception> exceptionList){
		
		if (individuals.size() > 0){
			if (asCVS){
				StringBuilder results = addResultsToCSVString(individuals, exceptionList);
				writeToNewFile(filename, results, iteration, exceptionList, ".csv");
			} 
			if (asEMF){
				// save as EMF files
				Candidates candidates = EMFHelper.createEMFCandidates(individuals);
				EMFHelper.saveToXMIFile(candidates, getFilenameForIteration(filename, iteration, ".designdecision"));
			}
		}
	}
	
	/**
	 * Write all individuals to new file (file current time in filename).
	 * @param individuals
	 * @param filename
	 * @param iteration
	 * @param exceptionList
	 * @param asEMF 
	 */
	public static void writeIndividualsToFile(Collection<Individual> individuals, String filename, int iteration,
			List<Exception> exceptionList, boolean asEMF, boolean asCSV){
		List<DSEIndividual> dseIndList = new ArrayList<DSEIndividual>(individuals.size());
		for (Individual ind : individuals) {
			if (ind instanceof DSEIndividual){
				dseIndList.add((DSEIndividual)ind);
			}
		}	
		writeDSEIndividualsToFile(dseIndList, filename, iteration, asEMF, asCSV, exceptionList);
	}
	

	/**
	 * Write any string to the given file. 
	 * @param filename
	 * @param content
	 * @param iteration Is used for the filename
	 * @param exceptionList
	 */
	public static void writeStringToFile(String filename, String content, int iteration, List<Exception> exceptionList, String fileEnding){
		writeToNewFile(filename, new StringBuilder(content), iteration, exceptionList, fileEnding);
	}


	/**
	 * Write individuals to Logger using WARN level.
	 * @param individuals
	 * @param collectionName
	 */
	public static void printOutIndividuals(Collection<DSEIndividual> individuals,
			String collectionName) {
		
		if (individuals.iterator().hasNext()){
		
		DSEIndividual firstIndividual = individuals.iterator().next();
		List<Criterion> criteriaToSave = determineCriterionsToSave(firstIndividual);
		List<Criterion> criteriaWithConfidence = determineCriteriaWithConfidenceInterval(firstIndividual);
				
		logger.warn("------------ RESULTS " + collectionName
				+ " ----------------------");
		logger.warn("Printing results (number is " + individuals.size() + ").");
		
		List<Exception> exceptionList = new ArrayList<Exception>();
		
		int counter = 0;
	
		StringBuilder output = new StringBuilder(10000);
		
		logger.warn("------------ PRETTY CSV RESULTS " + collectionName
				+ " ----------------------");
		
		output.append("\n");
		output = prettyPrintHeadlineCSV(individuals, output,criteriaToSave);
	
		// content
		for (DSEIndividual ind2 : individuals) {
			try {
			output = prettyPrintResultLineCSV(output, ind2,criteriaToSave, criteriaWithConfidence);
			} catch (Exception e){
				exceptionList.add(new Exception("Encountered corrupted result number "+counter+", skipped it", e));
			}
			counter++;
		}
		logger.warn(output);
		
		if (exceptionList.size() > 0){
			logger.warn("Encountered exceptions while printing results");
			for (Exception exception : exceptionList) {
				exception.printStackTrace();
			}
		}
		}
	}



	public static String formatDouble(Double gene) {
		return Double.toString(gene);
	}


	
	public void writeIndividual(DSEIndividual i){
		
		List<DSEIndividual> individualList = new ArrayList<DSEIndividual>(1);
		individualList.add(i);
		
		StringBuilder result = new StringBuilder(100);
		
		if (this.criteriaToSave == null){
			//This is the first individual, so write headline, too. 
			//this method also determines the objectives
			this.criteriaToSave = determineCriterionsToSave(i);
			result = prettyPrintHeadlineCSV(individualList, result, this.criteriaToSave);
		} 
		
		if (this.criteriaWithConfidence == null){
			this.criteriaWithConfidence = determineCriteriaWithConfidenceInterval(i);
		}
		//Write the result line 
		result = prettyPrintResultLineCSV(result, i, this.criteriaToSave, this.criteriaWithConfidence);
		
		this.write(result);
		
	}



	public String getFilename() {
		return this.myfilename;
	}



	public void writeTacticCandidateInfo(ITactic heuristic, Collection<TacticsResultCandidate> candidatesFromCurrentHeuristic){
		 //writeToLogFile(heuristic.getClass() + ";" + candidatesFromCurrentHeuristic.size() + "; candidate(s)");
		for (TacticsResultCandidate tacticsResultCandidate : candidatesFromCurrentHeuristic) {
			StringBuilder builder = new StringBuilder(30);
			builder.append(heuristic.getClass().getSimpleName()+";"+tacticsResultCandidate.getNumericID()+";"+tacticsResultCandidate.getParent().getNumericID()+";"+tacticsResultCandidate.getID()+";"+tacticsResultCandidate.getParent().getID()+";");
			builder = printUtilResultLine(tacticsResultCandidate.getParent(), builder);
			writeToLogFile(builder.toString()+"\n");
		}
	}

	public void writeTacticManagerChoice(TacticsResultCandidate c){
		writeToLogFile(c.getHeuristic().getClass().getSimpleName() +";"+c.getNumericID()+";"+c.getParent().getNumericID()+ ";"+c.getID()+";"+c.getParent().getID()+";candidate returned\n");
	}
	
	
	/**
	 * Writes String entry to log file in results directory. 
	 * @param entry
	 */
	public void writeToLogFile(String entry) {
		try{
			StringBuilder out = new StringBuilder(50);
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    out.append(sdf.format(cal.getTime()) + ";" + entry);
		    
		    this.write(out);
		}catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		}
	}


	public void flush() {
		try {
			this.fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	/**
	 * Closes the internal file writer (as defined in FileWriter.close()). 
	 * After closing, the ResultWriter should not be used anymore. 
	 * Further calls of the ResultWriter will be logged to Log4J with error messages, as if 
	 * no file writer could be initialised. 
	 * Multiple calls of close() have no effect.   
	 */
	public void close(){
		if (this.fileWriter != null){
			try {
				this.fileWriter.flush();
				this.fileWriter.close();
				this.fileWriter = null;
			} catch (IOException e) {
				logger.error("Cannot close the file handle "+this.myfilename+". Your results might be lost. Cause: "+e.getMessage());
				e.printStackTrace();
			}
	
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		this.close();
		super.finalize();
	}



	/**
	 * Writes the individuals to a StringBuffer in csv format.
	 * @param individuals
	 * @param exceptionList
	 * @return
	 */
	private static StringBuilder addResultsToCSVString(Collection<DSEIndividual> individuals,
			List<Exception> exceptionList) {
		StringBuilder output = new StringBuilder(10000);
		
		DSEIndividual firstIndividual = individuals.iterator().next();
		
		List<Criterion> criteriaToSave = determineCriterionsToSave(firstIndividual);
		List<Criterion> criteriaWithConfidence = determineCriteriaWithConfidenceInterval(firstIndividual);

		output = prettyPrintHeadlineCSV(individuals, output, criteriaToSave);
		int counter = 0;

		// content
		for (DSEIndividual ind2 : individuals) {
			try {
			output = prettyPrintResultLineCSV(output, ind2,criteriaToSave, criteriaWithConfidence);
			} catch (Exception e){
				exceptionList.add(new Exception("Encountered corrupted result number "+counter+", skipped it", e));
			}
			counter++;
		}
		return output;
	}

	private static List<Criterion> determineCriteriaWithConfidenceInterval(
			DSEIndividual firstIndividual) {
		DSEObjectives objs = firstIndividual.getObjectives();
		List<Criterion> criteriaWithConfidence = new ArrayList<Criterion>();
		
		if (objs != null && objs.size() > 0){
			List<String> coveredDimensions = new ArrayList<String>();

			for (Objective objective : objs.getKeys()) {
				if (objs.getConfidenceIntervalForObjective(objective) != null){
					criteriaWithConfidence.add(objective);
					coveredDimensions.add(getDimensionName(objective));
				}
			}

			for (Constraint constraint : objs.getConstraints().getKeys()) {
				if (!coveredDimensions.contains(getDimensionName(constraint))){
					if (objs.getConfidenceIntervalForObjective(constraint) != null){
						criteriaWithConfidence.add(constraint);
					}
				}
			}
		}
		
		return criteriaWithConfidence;
	}


	private static void writeToNewFile(String filename, StringBuilder results, int iteration, List<Exception> exceptionList, String fileEnding) {
		filename = getFilenameForIteration(filename, iteration, fileEnding);
		try {
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(filename)));
			
			w.write(results.toString());
			
			w.flush();
			
			w.close();
		} catch (FileNotFoundException e) {
			exceptionList.add(e);
			e.printStackTrace();
		} catch (IOException e) {
			exceptionList.add(e);
			e.printStackTrace();
		}
		
	}


	private static String getFilenameForIteration(String basicFilename, int iteration, String fileEnding) {
		return basicFilename +iteration+"_" +getTimeDateString()+fileEnding;
	}
	
	private static StringBuilder prettyPrintResultLineCSV(StringBuilder output, DSEIndividual ind, List<Criterion> criterionsToSave, List<Criterion> criteriaWithConfidence) {
		
		// first objectives
		DSEObjectives objs = ind.getObjectives();
		//for (Entry<Objective, Value<?>> entry : objs) { 
		for (Criterion o : criterionsToSave) {
			if (objs != null){
				output.append(formatValue(objs.getValueForCriterion(o)) + ";");
			} else {
				output.append(formatDouble(Double.NaN) + ";");
			}
		}
		
		//then confidences if available
		if (ind.getPhenotype() instanceof PCMPhenotype){
			for (Criterion o : criteriaWithConfidence) {
				ConfidenceInterval c = objs.getConfidenceIntervalForObjective(o);
				if (c != null){
					output.append(c.getLowerBound()+";"+c.getUpperBound()+";"+c.getLevel()+";"); 
				} else {
					output.append(Double.NaN+";"+Double.NaN+";"+Double.NaN+";");
				}
			}
		}
		
		//then genes
		DesignDecisionGenotype genes = (DesignDecisionGenotype) ind.getGenotype();
		if (genes.size() == 0){
			logger.error("Encountered empty genotype, filling it with blanks");
			int problemsize = Opt4JStarter.getProblem().getDesignDecisions().size();
			for (int i = 0; i < problemsize; i++) {
				output.append(";");
			}
			
		} else {
			output.append(DSEDecoder.getGenotypeString(genes));
		}
		
		output = printUtilResultLine(ind,output);
		
		output.append(((PCMPhenotype)ind.getPhenotype()).getNumericID()+";");
		
		output.append("\n");
		return output;
	}

	/**
	 * Print one column per objective with results and per active processing resource in the resourceenvironment.  
	 * @param ind
	 * @param output
	 * @return
	 */
	private static StringBuilder printUtilResultLine(DSEIndividual ind,
			StringBuilder output) {
		
		Objectives obs = ind.getObjectives();
		if (obs instanceof DSEObjectives){
			DSEObjectives dseObj = ((DSEObjectives)obs);
			for (Entry<Objective, Value<?>> o : dseObj) {
				if (dseObj.hasResultDecoratorFor(o.getKey())){
					ResultDecoratorRepository results = dseObj.getResultDecoratorFor(o.getKey());
					List<UtilisationResult> utilisations = results.getUtilisationResults_ResultDecoratorRepository();
					PCMInstance pcm = Opt4JStarter.getProblem().getInitialInstance();
					List<ResourceContainer> containers = pcm.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
					List<LinkingResource> links = pcm.getResourceEnvironment().getLinkingResources__ResourceEnvironment();
					if (utilisations != null){
						for (ResourceContainer resourceContainer : containers) {
							for (ProcessingResourceSpecification processingResourceSpecification : resourceContainer.getActiveResourceSpecifications_ResourceContainer()) {
								for (UtilisationResult utilisationResult : utilisations) {
									if (utilisationResult instanceof ProcessingResourceSpecificationResult){
										ProcessingResourceSpecificationResult procResResult = ((ProcessingResourceSpecificationResult)utilisationResult);
										// compare container and resource type, because the proc resource may have changed (the printed candidate is not necessarily the current one on the blackboard). 
										if (EMFHelper.checkIdentity((ResourceContainer)procResResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().eContainer(),resourceContainer)
												&& EMFHelper.checkIdentity(procResResult.getProcessingResourceSpecification_ProcessingResourceSpecificationResult().getActiveResourceType_ActiveResourceSpecification(), processingResourceSpecification.getActiveResourceType_ActiveResourceSpecification())){
											output.append(procResResult.getResourceUtilisation());
											break;
										}
									}
								}
								output.append(";");
							}
						}
						for (LinkingResource linkingResource : links) {
							for (UtilisationResult utilisationResult : utilisations) {
								if (utilisationResult instanceof LinkingResourceResults){
									LinkingResourceResults linkResult = ((LinkingResourceResults)utilisationResult);
									if (EMFHelper.checkIdentity(linkResult.getLinkingResource_LinkingResourceResults(),linkingResource)){
										output.append(linkResult.getResourceUtilisation());
										break;
									}
								}
							}
							output.append(";");
						}
					} else {
					  for (int i = 0; i < containers.size()+links.size(); i++){
						  output.append(";");
					  }
					}
				
				}
			}
		}
		
		return output;
	}

	/**
	 * If order of all Objectives first, then confidences is changed, also change GenotypeReader accordingly.
	 * Expects a list of objectives to create a headline entry for.  
	 * @param individuals
	 * @param output
	 * @param criterionsToSave
	 * @return
	 */
	private static StringBuilder prettyPrintHeadlineCSV(
			Collection<DSEIndividual> individuals, StringBuilder output, List<Criterion> criterionsToSave) {
		if (individuals.size() > 0){
			DSEIndividual i = individuals.iterator().next();
			
			output = printObjectives(criterionsToSave,output);
		
			output = determineAndPrintConfidenceIntervalHeadline(output, i.getObjectives(), criterionsToSave);
		
			output.append(Opt4JStarter.getProblem().toString());
		
			output = printUtilisationHeadline(i,output);
			
			output.append("Candidate ID;");
		
			output.append("\n");
		}
		return output; 
	}
	
	/**
	 * Print one column per objective with results and per active processing resource in the resourceenvironment.  
	 * @param i
	 * @param output
	 * @return
	 */
	private static StringBuilder printUtilisationHeadline(DSEIndividual i,
			StringBuilder output) {
		Objectives obs = i.getObjectives();
		if (obs instanceof DSEObjectives){
			DSEObjectives dseObj = ((DSEObjectives)obs);
			for (Entry<Objective, Value<?>> o : dseObj) {
				if (dseObj.hasResultDecoratorFor(o.getKey())){
		
					PCMInstance pcm = Opt4JStarter.getProblem().getInitialInstance();
					List<ResourceContainer> containers = pcm.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
					for (ResourceContainer resourceContainer : containers) {
						List<ProcessingResourceSpecification> procResource = resourceContainer.getActiveResourceSpecifications_ResourceContainer();
						for (ProcessingResourceSpecification processingResourceSpecification : procResource) {
							ProcessingResourceType procType = processingResourceSpecification.getActiveResourceType_ActiveResourceSpecification();
							output.append("Util of "+resourceContainer.getEntityName()+" "+procType.getEntityName()+";");
						}
						
					}
					
					List<LinkingResource> links = pcm.getResourceEnvironment().getLinkingResources__ResourceEnvironment();
					for (LinkingResource linkingResource : links) {
						output.append("Util of "+linkingResource.getEntityName()+" "
								+linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource().getCommunicationLinkResourceType_CommunicationLinkResourceSpecification().getEntityName()+";");
					}
				}
				
			}
		}
		return output;
	}

	private static StringBuilder determineAndPrintConfidenceIntervalHeadline(StringBuilder output, DSEObjectives objs, List<Criterion> criterionsToSave) {
	
		for (Criterion criterion : criterionsToSave) {
			ConfidenceInterval c = objs.getConfidenceIntervalForObjective(criterion);
			if (c != null){
				output.append(DSEConstantsContainer.LOWER_BOUND_CONFIDENCE+"("+getDimensionName(criterion)+");"
						+ DSEConstantsContainer.UPPER_BOUND_CONFIDENCE+"("+getDimensionName(criterion)+");"
						+ DSEConstantsContainer.ALPHA+"("+getDimensionName(criterion)+");"); 
			}
		
		}
		return output;
	}


	private static List<Criterion> determineCriterionsToSave(DSEIndividual i) {
		DSEObjectives objs = i.getObjectives();
		
		
		List<Criterion> criterionsToSave = new ArrayList<Criterion>();
		if (objs != null && objs.size() != 0){
			criterionsToSave.addAll(objs.getKeys());

			// check for each constraint whether an objective already covers its quality dimension. If not, it needs to be added to the list
			Collection<Constraint> constraints = objs.getConstraints().getKeys();
			for (Constraint constraint : constraints) {
				boolean hasToBeAdded = true;
				for (Criterion coveredCriterion : criterionsToSave) {
					if (getDimensionName(constraint).equals(getDimensionName(coveredCriterion))){
						// criterion is already covered
						hasToBeAdded = false;
						break;
					}
				}
				if (hasToBeAdded){
					criterionsToSave.add(constraint);
				}
			}
		}
		return criterionsToSave;
	}

	private static String formatValue(Value<?> value) {
		
		if (value instanceof IntegerValue){
			IntegerValue intValue = (IntegerValue)value;
			return String.valueOf(intValue);
			
		} else {
			double d = value.getDouble();
			return formatDouble(d);
		}
		
	}

	
	private static StringBuilder printObjectives(List<Criterion> criterionsToSave, StringBuilder output) {
		for (Criterion entry : criterionsToSave) {
			output.append(getDimensionName(entry) +";");
		}

		return output;
	}

	private static String getTimeDateString(){
		Date date = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
		String stringDate = simpleFormat.format(date);
		stringDate = stringDate.replaceAll(":", "-").replaceAll(" ", "_");
		return  stringDate;
	}
	
	/**
	 * Write the string to this.fileWriter. 
	 * @param result
	 */
	private void write(StringBuilder result) {
		if (this.fileWriter != null){
			try {
				fileWriter.write(result.toString());
				fileWriter.flush();
			} catch (IOException e) {
				logger.error("Cannot write to file "+this.myfilename+" Logging the result at level INFO now. Cause: "+e.getMessage());
				logger.info(result.toString());
			}
		} else {
			logger.info(result.toString());
		}
	}
	
	public static String getDimensionName(Criterion criterion){
		EvaluationAspectWithContext qmlCriterion = PCMDeclarationsReader.retranslateCriterionToEvaluationAspect(criterion);
		String name = qmlCriterion.getDimension().getEntityName();
		if (criterion instanceof UsageScenarioBasedCriterion){
			name += ":"+((UsageScenarioBasedCriterion)criterion).getUsageScenario().getEntityName();
		} else if (criterion instanceof EntryLevelSystemCallCriterion){
			name += ":"+((EntryLevelSystemCallCriterion)criterion).getEntryLevelSystemCall().getEntityName();
		}
		return name;
	}
	



}
